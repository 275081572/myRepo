package com.cn.smart.thread;

import java.util.concurrent.Callable;

public class TaskWithResult implements Callable<String> {

    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        System.out.println("call()方法被自动调用！！！  " + Thread.currentThread().getName());
        //该返回的结果将被Future的get()得到
        return "call()方法被自动调用，调用的结果是： " + id + " " + Thread.currentThread().getName();
    }
}
