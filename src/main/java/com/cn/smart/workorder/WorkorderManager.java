package com.cn.smart.workorder;

import com.cn.smart.test.TrsPriceDto;
import com.cn.smart.workorder.chain.Chain;
import com.cn.smart.workorder.chain.CheckParamHandler;
import com.cn.smart.workorder.chain.CheckStatusHandler;
import com.cn.smart.workorder.chain.WorkorderContext;
import com.cn.smart.workorder.template.AbstractTemplate;
import com.cn.smart.workorder.template.StrategyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

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
//        WorkorderContext context = new WorkorderContext();
//        context.setValue("xxx");
//        context.setStatus(3);
//
//        Chain<WorkorderContext> workorderContextChain = new Chain<>(checkParamHandler, checkStatusHandler);
//        workorderContextChain.handle(context);

        List<TrsPriceDto> list = new ArrayList<>();
        list.add(new TrsPriceDto("GD001", "1"));
        list.add(new TrsPriceDto("GD002", "1"));
        list.add(new TrsPriceDto("GD001", "1"));
        List<TrsPriceDto> collect = list.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(() ->
                new TreeSet<>(Comparator.comparing(TrsPriceDto::getRefNo))), ArrayList::new));
        System.out.println(collect);
    }

    @GetMapping("/chain/test2")
    public void test2() {
        ThreadLocal t = new ThreadLocal();
        WorkorderContext context = new WorkorderContext();
        context.setValue("xxx");
        context.setStatus(3);

        AbstractTemplate<WorkorderContext, String> abstractTemplate = strategyService.getTemplate(1);
        abstractTemplate.initProcess(context);
		try {
            abstractTemplate.templateProcess(context);
        } catch (Exception e) {
            abstractTemplate.rollbackProcess(context);
        }
    }

}
