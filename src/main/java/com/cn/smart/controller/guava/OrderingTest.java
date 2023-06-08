package com.cn.smart.controller.guava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.common.collect.Ordering;

/**
 * TODO
 *
 * @author xuwei
 * @date 2023/4/18
 */

public class OrderingTest {

    public static void main(String args[]) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(new Integer(5));
        numbers.add(new Integer(2));
        numbers.add(new Integer(15));
        // 自然排序
        Ordering ordering = Ordering.natural();
        Collections.sort(numbers, ordering);
        System.out.println("Sorted List: ");
        System.out.println(numbers);
        // 找出最大值和最小值
        System.out.println("======================");
        System.out.println("Minimum: " + ordering.min(numbers));
        System.out.println("Maximum: " + ordering.max(numbers));
        // 倒序
        Collections.sort(numbers, ordering.reverse());
        System.out.println("Reverse: " + numbers);
        // 加入null, null在末尾
        numbers.add(null);
        System.out.println("Null added to Sorted List: ");
        System.out.println(numbers);
        // 将null置于首位
        Collections.sort(numbers, ordering.nullsFirst());
        System.out.println("Null first Sorted List: ");
        System.out.println(numbers);
        System.out.println("======================");
        // 取出前2位最大值
        numbers.remove(null);
        List<Integer> list = ordering.greatestOf(numbers, 2);
        System.out.println(list);
        System.out.println("======================");
        // 取出前2位最小值
        List<Integer> list2 = ordering.leastOf(numbers, 2);
        System.out.println(list2);
    }

}
