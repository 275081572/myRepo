package com.cn.smart.controller.guava;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.common.base.Splitter;

/**
 * TODO
 *
 * @author xuwei
 * @date 2023/4/19
 */

public class SplitterTest {

    public static void main(String[] args) {
        // use java
        List<String> list = new ArrayList<>();
        String a = "1-2-3-4-5-6";
        String[] strs = a.split("-");
        for (int i = 0; i < strs.length; i++) {
            list.add(strs[i]);
        }

        // use guava
        String str = "1-2-3-4-5-6";
        List<String> list2 = Splitter.on("-").splitToList(str);
        System.out.println(list2);
        // list2为 [1, 2, 3, 4, 5, 6]

        // guava还可以使用 omitEmptyStrings().trimResults() 去除空串与空格
        String str2 = "1-2-3-4-  5-  6   ";
        List<String> list3 = Splitter.on("-").omitEmptyStrings().trimResults().splitToList(str2);
        System.out.println(list3);
        // list3为 [1, 2, 3, 4, 5, 6]

        // 将String转换为map
        String str3 = "xiaoming=11,xiaohong=23";
        Map<String, String> map = Splitter.on(",").withKeyValueSeparator("=").split(str3);
        System.out.println(map);
        // {xiaoming=11, xiaohong=23}

        // guava还支持多个字符切割，或者特定的正则分隔
        String input = "aa.dd,,ff,,.";
        List<String> result = Splitter.onPattern("[.|,]").omitEmptyStrings().splitToList(input);
        System.out.println(result);
        // [aa, dd, ff]
    }
}
