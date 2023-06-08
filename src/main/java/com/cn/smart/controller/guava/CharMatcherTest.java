package com.cn.smart.controller.guava;

import com.google.common.base.CharMatcher;

/**
 * TODO
 *
 * @author xuwei
 * @date 2023/4/19
 */

public class CharMatcherTest {

    public static void main(String[] args) {
        // 从字符串中得到所有的数字
        String value = CharMatcher.DIGIT.retainFrom("some text 2046 and more");
        System.out.println(value);
        // 2046

        // 回车换行对应换成一个#，一对一换
        String stringWithLinebreaks = "hello world\r\r\ryou are here\n\ntake it\t\t\teasy";
        String s6 = CharMatcher.BREAKING_WHITESPACE.replaceFrom(stringWithLinebreaks, '#');
        System.out.println(s6);
        // hello#world###you#are#here##take#it###easy

        // 将所有连在一起的回车换行字符换成一个#
        String tabString = "  hello   \n\t\tworld   you\r\nare             here  ";
        String tabRet = CharMatcher.WHITESPACE.collapseFrom(tabString, '#');
        System.out.println(tabRet);
        // #hello#world#you#are#here#

        // 在前面的基础上去掉字符串的前后空白，并将空白换成一个#
        String trimRet = CharMatcher.WHITESPACE.trimAndCollapseFrom(tabString, '#');
        System.out.println(trimRet);
        // hello#world#you#are#here

        // 判断匹配结果
        boolean result = CharMatcher.inRange('a', 'z').or(CharMatcher.inRange('A', 'Z')).matches('K');
        // true
        String s1 = CharMatcher.inRange('0', '9').retainFrom("abc 123 efg");
        // 123
        // 删除数字文本 remove 删除
        String s2 = CharMatcher.inRange('0', '9').removeFrom("abc 123 efg");
        // abc efg
    }
}
