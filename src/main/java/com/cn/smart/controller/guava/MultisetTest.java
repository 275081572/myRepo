package com.cn.smart.controller.guava;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

/**
 * TODO
 *
 * @author xuwei
 * @date 2023/4/18
 */

public class MultisetTest {

    public static void main(String args[]) {
        Multiset<String> multiset = HashMultiset.create();
        multiset.add("a");
        multiset.add("b", 4);
        // 统计元素a的条数
        System.out.println("Occurrence of 'a' : " + multiset.count("a"));
        // 统计集合的总条数
        System.out.println("Total Size : " + multiset.size());
        // 获取set，元素不重复
        Set<String> set = multiset.elementSet();
        // 输出所有元素
        Iterator<String> iterator = multiset.iterator();
        System.out.println("MultiSet [");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("]");
        // 输出元素及其对应条数
        for (Multiset.Entry<String> entry : multiset.entrySet()) {
            System.out.println("Element: " + entry.getElement() + ", Occurrence(s): " + entry.getCount());
        }
        // 移除一条元素a
        multiset.remove("a");
        System.out.println("Occurence of 'a' : " + multiset.count("a"));
        // 移除全部元素a
        multiset.removeAll(Arrays.asList("a"));
        System.out.println("Occurence of 'a' : " + multiset.count("a"));
        // 移除元素b指定条数
        multiset.remove("b", 2);
        System.out.println("Occurence of 'b' : " + multiset.count("b"));
        // 设置元素a指定条数
        multiset.setCount("a", 10);
        System.out.println("Occurence of 'a' : " + multiset.count("a"));
    }

}
