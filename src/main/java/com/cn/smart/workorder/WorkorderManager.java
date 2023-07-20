package com.cn.smart.workorder;

import com.cn.smart.workorder.chain.Chain;
import com.cn.smart.workorder.chain.CheckParamHandler;
import com.cn.smart.workorder.chain.CheckStatusHandler;
import com.cn.smart.workorder.chain.WorkorderContext;
import com.cn.smart.workorder.template.AbstractTemplate;
import com.cn.smart.workorder.template.StrategyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author xuwei
 * @date 2023/7/20
 */

@RestController
public class WorkorderManager {

    @Autowired
    private CheckStatusHandler checkStatusHandler;

    @Autowired
    private CheckParamHandler checkParamHandler;

    @Autowired
    private StrategyService strategyService;

    @GetMapping("/chain/test")
    public void test() {
        WorkorderContext context = new WorkorderContext();
        context.setValue("xxx");
        context.setStatus(3);

        Chain<WorkorderContext> workorderContextChain = new Chain<>(checkParamHandler, checkStatusHandler);
        workorderContextChain.handle(context);
    }

    @GetMapping("/chain/test2")
    public void test2() {
        WorkorderContext context = new WorkorderContext();
        context.setValue("xxx");
        context.setStatus(3);

        AbstractTemplate<WorkorderContext, String> abstractTemplate = strategyService.getTemplate(2);
        abstractTemplate.initProcess(context);
		try {
            abstractTemplate.templateProcess(context);
        } catch (Exception e) {
            abstractTemplate.rollbackProcess(context);
        }
    }

}
