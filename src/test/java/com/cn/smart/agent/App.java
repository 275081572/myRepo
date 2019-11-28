package com.cn.smart.agent;

import java.lang.reflect.Proxy;

public class App {

    public static void main(String[] args) {
        //静态代理
        /*Vendor vendor = new Vendor();
        BusinessAgent businessAgent = new BusinessAgent(vendor);
        businessAgent.sell();
        businessAgent.ad();*/

        //动态代理
        //创建中介实例
        DynamicProxy dynamicProxy = new DynamicProxy(new Vendor());
        //动态生成代理类文件
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        //获取代理类实例shell
        Sell sell = (Sell) (Proxy.newProxyInstance(Sell.class.getClassLoader(), new Class[]{Sell.class}, dynamicProxy));
        //通过代理类对象调用代理类方法，实际上会转到invoke方法调用
        sell.sell();
        sell.ad();
    }
}
