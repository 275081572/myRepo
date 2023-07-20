package com.cn.smart.workorder.template;

import com.cn.smart.workorder.chain.Chain;
import com.cn.smart.workorder.chain.WorkorderContext;

import java.util.Objects;

/**
 * TODO
 *
 * @author xuwei
 * @date 2023/7/20
 */

public abstract class AbstractTemplate<P, O> implements ITemplate<P, O> {

    @Override
    public void initProcess(P p) {
        Chain<P> chain = initChina();
        if(Objects.nonNull(chain)){
            if(!chain.handle(p)){
                throw new RuntimeException("业务处理失败");
            }
        }
    }

    protected abstract Chain<P> initChina();

}
