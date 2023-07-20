package com.cn.smart.controller.guava;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

/**
 * TODO
 *
 * @author xuwei
 * @date 2023/6/12
 */

public class Test {

    public static void main(String[] args) throws InterruptedException {
        // 当我们需要map中包含key为String类型，value为List类型的是， 以前是这么写的
        Map<String, List<Integer>> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        map.put("name", list);
        List<Integer> list1 = map.get("name");

        // 而现在只需要这么写
        Multimap<String, Integer> multimap = ArrayListMultimap.create();
        multimap.put("name", 1);
        multimap.put("name", 2);
        List<Integer> list2 = map.get("multimap");

        long start = System.currentTimeMillis();
        Thread.sleep(100);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
