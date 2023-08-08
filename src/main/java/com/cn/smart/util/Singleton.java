package com.cn.smart.util;

/**
 * @desc 双重校验锁实现单列模式
 * @author xuwei
 * @time 2023/7/25 10:13
 */
public class Singleton {

    private static volatile Singleton singleton;

    private Singleton(){};

    public static Singleton get() {
        if(null == singleton){
            synchronized (Singleton.class) {
                if(null == singleton){
                    singleton = new Singleton();
                    return singleton;
                }
            }
        }
        return singleton;
    }

}
