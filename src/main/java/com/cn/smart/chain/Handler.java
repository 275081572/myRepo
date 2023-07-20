package com.cn.smart.chain;

/**
 * TODO
 *
 * @author xuwei
 * @date 2023/7/19
 */

public abstract class Handler {

    protected Handler handler;

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public abstract void hanleRequest(Integer times);
}
