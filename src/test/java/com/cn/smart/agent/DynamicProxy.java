package com.cn.smart.agent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author ChuangLan
 * 中介类
 * 动态代理关系由两组静态代理关系组成
 */
public class DynamicProxy implements InvocationHandler {

    //委托类对象
    private Object object;

    public DynamicProxy(Object object){
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before...");
        Object result = method.invoke(object, args);
        System.out.println("after...");
        return result;
    }
}
