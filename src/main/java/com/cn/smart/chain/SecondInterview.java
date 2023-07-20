package com.cn.smart.chain;

/**
 * TODO
 *
 * @author xuwei
 * @date 2023/7/19
 */

public class SecondInterview extends Handler{

    @Override
    public void hanleRequest(Integer times) {
        if(times == 2){
            System.out.println("第二次面试");
        }
        handler.hanleRequest(times);
    }

}
