package com.cn.smart.controller.guava;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * TODO
 *
 * @author xuwei
 * @date 2023/4/18
 */

public class BimapTest {

    public static void main(String args[]) {
        BiMap<Integer, String> empIDNameMap = HashBiMap.create();

        empIDNameMap.put(101, "Mahesh");
        empIDNameMap.put(102, "Sohan");
        empIDNameMap.put(103, "Ramesh");

        System.out.println(empIDNameMap.get(101));
        System.out.println(empIDNameMap.inverse().get("Mahesh"));
        System.out.println(empIDNameMap.values());
    }

}
