package com.cn.smart.chain;

/**
 * TODO
 *
 * @author xuwei
 * @date 2023/7/19
 */

public class FirstInterview extends Handler{

    @Override
    public void hanleRequest(Integer times) {
        if(times == 1){
            System.out.println("第一次面试");
        }
        handler.hanleRequest(times);
    }

}
