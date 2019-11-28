package com.cn.smart.agent;

/**
 * @author ChuangLan
 * 静态代理类
 */
public class BusinessAgent implements Sell{

    private Vendor vendor;

    public BusinessAgent(Vendor vendor){
        this.vendor = vendor;
    }

    @Override
    public void sell() {
        vendor.sell();
    }

    @Override
    public void ad() {
        vendor.ad();
        System.out.println("haha...");
    }
}
