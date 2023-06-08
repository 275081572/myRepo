package com.cn.smart.controller.guava;

import com.google.common.base.Strings;

/**
 * TODO
 *
 * @author xuwei
 * @date 2023/4/19
 */

public class StringTest {

    public static void main(String[] args) {
        System.out.println(Strings.isNullOrEmpty(""));
        // true
        System.out.println(Strings.isNullOrEmpty(null));
        // true
        System.out.println(Strings.isNullOrEmpty("hello"));
        // false
        // 将null转化为"",非null则不转换
        System.out.println(Strings.nullToEmpty(null));
        // ""
        // 从尾部不断补充T只到总共8个字符，如果源字符串已经达到或超过，则原样返回。类似的有padStart
        System.out.println(Strings.padEnd("hello", 8, 'T'));
        // helloTTT
        System.out.println(Strings.repeat("Hello", 3));
        // HelloHelloHello
    }

}
