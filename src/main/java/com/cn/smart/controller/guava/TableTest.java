package com.cn.smart.controller.guava;

import java.util.Map;
import java.util.Set;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

/**
 * TODO
 *
 * @author xuwei
 * @date 2023/4/18
 */

public class TableTest {

    public static void main(String args[]) {
        Table<String, String, String> table = HashBasedTable.create();
        // Table<R,C,V> == Map<R,Map<C,V>>
        table.put("Java", "101", "Mahesh");
        table.put("Java", "102", "Ramesh");
        table.put("Java", "103", "Suresh");

        table.put("JS", "101", "Ram");
        table.put("JS", "102", "Shyam");
        // 获取指定key的value
        String value = table.get("Java", "101");
        System.out.println("value:" + value);
        // 获取指定rowKey的map
        Map<String, String> javaMap = table.row("Java");
        javaMap.remove("101", "Mahesh");
        System.out.println("List of javaMap");
        for (Map.Entry<String, String> entry : javaMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        System.out.println("--------");
        // 获取所有rowKey
        Set<String> rowKeySet = table.rowKeySet();
        for (String rowKey : rowKeySet) {
            System.out.println("rowKey:" + rowKey);
        }
        // 获取包含指定column的map
        Map<String, String> columnKeyMap = table.column("102");
        for (Map.Entry<String, String> entry : columnKeyMap.entrySet()) {
            System.out.println("rowKey: " + entry.getKey() + ", value: " + entry.getValue());
        }
        // 判断是否包含指定columnKey
        boolean flag = table.containsColumn("103");
        System.out.println(flag);
    }

}
