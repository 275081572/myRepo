package com.cn.smart.workorder.chain;

/**
 * TODO
 *
 * @author xuwei
 * @date 2023/7/20
 */

public interface ChainHandler<T> {

    /**
     * 检查是否满足执行该节点的要求
     */
    default boolean check(T t){
        return true;
    }

    /**
     * 具体需要实现的业务逻辑
     *
     * @param t
     * @return
     */
    boolean handle(T t);
}
