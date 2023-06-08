package com.cn.smart.controller.guava;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

/**
 * TODO
 *
 * @author xuwei
 * @date 2023/4/18
 */

public class MultimapTest {

    public static void main(String args[]) {
        MultimapTest tester = new MultimapTest();
        Multimap<String, String> multimap = tester.getMultimap();
        // 获取指定key的value集合
        List<String> lowerList = (List<String>) multimap.get("lower");
        System.out.println(lowerList.toString());
        // 增加value
        lowerList.add("f");
        System.out.println(lowerList);
        List<String> upperList = (List<String>) multimap.get("upper");
        System.out.println(upperList.toString());
        // 移除value
        upperList.remove("D");
        System.out.println(upperList);
        // 转化为map
        Map<String, Collection<String>> map = multimap.asMap();
        System.out.println("Multimap as a map");
        for (Map.Entry<String, Collection<String>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        // 获取key集合
        System.out.println("Keys of Multimap");
        Set<String> keys = multimap.keySet();
        for (String key : keys) {
            System.out.println(key);
        }
        // 获取value集合
        System.out.println("Values of Multimap");
        Collection<String> values = multimap.values();
        System.out.println(values);
        // 删除一个键 - 值对
        multimap.remove("lower", "a");
        System.out.println(multimap);
    }

    private Multimap<String, String> getMultimap() {
        Multimap<String, String> multimap = ArrayListMultimap.create();
        multimap.put("lower", "a");
        multimap.put("lower", "b");
        multimap.put("lower", "c");
        multimap.put("lower", "d");
        multimap.put("lower", "a");

        multimap.put("upper", "A");
        multimap.put("upper", "B");
        multimap.put("upper", "C");
        multimap.put("upper", "D");
        return multimap;
    }

}
