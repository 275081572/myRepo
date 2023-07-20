package com.cn.smart.chain;

/**
 * TODO
 *
 * @author xuwei
 * @date 2023/7/19
 */

public class ThreeInterview extends Handler{

    @Override
    public void hanleRequest(Integer times) {
        if(times == 3){
            System.out.println("第三次面试,恭喜通过");
        }
    }

    public static void main(String[] args) {
        Handler first = new FirstInterview();
        Handler second = new SecondInterview();
        Handler three = new ThreeInterview();
        first.setHandler(second);
        second.setHandler(three);

        //第一次面试
        first.hanleRequest(1);
        first.hanleRequest(2);
        first.hanleRequest(3);
    }
}
