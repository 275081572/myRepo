package com.cn.smart.dto;

import lombok.Data;

/**
 * @Description
 * @Author xuwei
 * @Date 2020/4/21 20:36
 **/
@Data
public class Account {

    private String id;

    private Member member;

    @Data
    public static class Member{
        private String name;

        private Integer age;
    }
}
