package com.cn.smart.thread;

public class Chap2 {

    public static void main(String[] args) {
        Chap2.test();
    }

    public static void test(){
        Thread t1 = new Thread(){
            @Override
            public void run(){
                for(int i = 0; i < 10; i++){
                    System.out.println("t1: " + i);
                }
            }
        };
        t1.start();


        Thread t2 = new Thread(){
            @Override
            public void run(){
                for(int i = 0; i < 10; i++){
                    System.out.println("t2: " + i);
                }
            }
        };
        t2.start();
    }
}
