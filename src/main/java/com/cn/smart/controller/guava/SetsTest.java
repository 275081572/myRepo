package com.cn.smart.controller.guava;

import java.util.Iterator;
import java.util.Set;

import com.google.common.collect.Sets;

/**
 * TODO
 *
 * @author xuwei
 * @date 2023/4/19
 */

public class SetsTest {

    public static void main(String[] args) {
        // 集合差
        Set<String> s1 = Sets.newHashSet("1", "2", "3", "4");
        Set<String> s2 = Sets.newHashSet("2", "3", "4", "5");
        // 得到第一个集合中有而第二个集合没有的字符串
        Sets.SetView res = Sets.difference(s1, s2);
        for (Iterator<String> it = res.iterator(); it.hasNext();) {
            System.out.println(it.next());
        }
        // 1

        // 集合对称差
        Sets.SetView res2 = Sets.symmetricDifference(s1, s2);
        for (Object it14 : res2) {
            System.out.println(it14);
        }
        // 1 5

        // 集合交
        Sets.SetView<String> res3 = Sets.intersection(s1, s2);
        for (String it14 : res3) {
            System.out.println(it14);
        }
        // 2 3 4

        // 集合并
        Sets.SetView<String> res4 = Sets.union(s1, s2);
        for (String it14 : res4) {
            System.out.println(it14);
        }
        // 1 2 3 4 5

    }
}
