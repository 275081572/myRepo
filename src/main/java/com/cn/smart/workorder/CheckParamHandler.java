package com.cn.smart.workorder;

import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @author xuwei
 * @date 2023/7/20
 */
@Service
public class CheckParamHandler implements ChainHandler<WorkorderContext> {
    @Override
    public boolean handle(WorkorderContext workorderContext) {
        System.out.println("参数校验通过：" + workorderContext.getValue());
        return true;
    }

}
