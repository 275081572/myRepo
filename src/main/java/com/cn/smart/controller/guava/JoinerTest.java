package com.cn.smart.controller.guava;

import java.util.List;
import java.util.Map;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * TODO
 *
 * @author xuwei
 * @date 2023/4/19
 */

public class JoinerTest {

    public static void main(String[] args) {
        // Joiner可以快速地把多个字符串或字符串数组连接成为用特殊符号连接的字符串
        List<String> list = Lists.newArrayList("a", "b", null, "c");
        String value = Joiner.on("-").skipNulls().join(list);
        System.out.println(value);
        // 输出：a-b-c

        // joiner.appendTo() 按照Joiner 规则追加
        StringBuilder stringBuilder = new StringBuilder();
        // 字符串连接器，以|为分隔符，同时去掉null元素
        Joiner joiner1 = Joiner.on("|").skipNulls();
        // 构成一个字符串foo|bar|baz并添加到stringBuilder
        stringBuilder = joiner1.appendTo(stringBuilder, "foo", "bar", null, "baz");
        System.out.println(stringBuilder);
        // 输出：foo|bar|baz

        // 把map集合转换为特定规则的字符串
        Map<String, Integer> map = Maps.newHashMap();
        map.put("xiaoming", 12);
        map.put("xiaohong", 13);
        String result = Joiner.on(",").withKeyValueSeparator("=").join(map);
        System.out.println(result);
        // 输出：xiaohong=13,xiaoming=12

        // 构造连接器：如果有null元素，替换为xxx
        StringBuilder stringBuilder2 = new StringBuilder("ABC");
        Joiner joiner2 = Joiner.on("#").useForNull("xxx");
        StringBuilder stringBuilder1 = joiner2.appendTo(stringBuilder2, "foo", "bar", null, "baz");
        System.out.println(stringBuilder1);
        // 输出：ABCfoo#bar#xxx#baz
    }
}
