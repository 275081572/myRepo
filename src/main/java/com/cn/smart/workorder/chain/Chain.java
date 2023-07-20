package com.cn.smart.workorder.chain;

import java.util.Arrays;
import java.util.List;

/**
 * TODO
 *
 * @author xuwei
 * @date 2023/7/20
 */

public class Chain<T> {

    private List<ChainHandler<T>> handlerList;

    public Chain(ChainHandler<T>...handlers) {
        handlerList = Arrays.asList(handlers);
    }

    public boolean handle(T t) {
        for(ChainHandler<T> handler :handlerList){
            if(!handler.check(t)){
                continue;
            }
            if(!handler.handle(t)){
                return false;
            }
        }
        return true;
    }

}
