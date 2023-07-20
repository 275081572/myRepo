package com.cn.smart.workorder.template;

/**
 * TODO
 *
 * @author xuwei
 * @date 2023/7/20
 */

public interface ITemplate<P, O> {

    void initProcess(P p);

    O templateProcess(P p);

    void rollbackProcess(P p);
}
