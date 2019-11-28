package com.cn.smart.agent;

/**
 * @author ChuangLan
 * 练习代理模式
 */
public class Vendor implements Sell{

    @Override
    public void sell() {
        System.out.println("sell something....");
    }

    @Override
    public void ad() {
        System.out.println("This is a surprise...");
    }
}
