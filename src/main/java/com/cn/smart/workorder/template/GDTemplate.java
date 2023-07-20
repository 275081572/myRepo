package com.cn.smart.workorder.template;

import com.cn.smart.workorder.chain.Chain;
import com.cn.smart.workorder.chain.CheckParamHandler;
import com.cn.smart.workorder.chain.CheckStatusHandler;
import com.cn.smart.workorder.chain.WorkorderContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * TODO
 *
 * @author xuwei
 * @date 2023/7/20
 */
@Service
@StrategyAnnotation(chooseType = StrategyEnum.GD)
public class GDTemplate extends AbstractTemplate<WorkorderContext, String>{

    @Autowired
    private CheckStatusHandler checkStatusHandler;

    @Autowired
    private CheckParamHandler checkParamHandler;

    @Override
    protected Chain<WorkorderContext> initChina() {
        return new Chain<>(checkParamHandler, checkStatusHandler);
    }

    @Override
    @Transactional
    public String templateProcess(WorkorderContext workorderContext) {
        System.out.println("已执行到核心流程。。。");
        return null;
    }

    @Override
    public void rollbackProcess(WorkorderContext workorderContext) {

    }
}
