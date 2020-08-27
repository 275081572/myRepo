package com.cn.smart.thread;

public class JoinMain {

    public  volatile static int i = 0;
    public static class AddThread extends Thread{
        @Override
        public void run() {
            for (i = 0; i < 10000000; i++);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AddThread at = new AddThread();
        at.start();
//        Thread.sleep(20);
        //实际是指当前线程在at线程后执行
        at.join();
        System.out.println(i);
    }
}
