package com.cn.smart.workorder.chain;

import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @author xuwei
 * @date 2023/7/20
 */
@Service
public class CheckStatusHandler implements ChainHandler<WorkorderContext> {
    @Override
    public boolean handle(WorkorderContext workorderContext) {
        System.out.println("状态校验通过：" + workorderContext.getStatus());
        return true;
    }

}
