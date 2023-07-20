package com.cn.smart.workorder.template;


/**
 * TODO
 *
 * @author xuwei
 * @date 2023/7/20
 */

public interface StrategyService<WorkorderContext> {

    AbstractTemplate<WorkorderContext, String> getTemplate(Integer type);
}
