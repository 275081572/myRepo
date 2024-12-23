package com.cn.smart.jdk21;


import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author xuwei
 * @date 2024-12-17 09:35
 * @description
 */
public class Test {

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3);
        var a = "abc";
        "abc".strip();

        var a1 ="abc";
    }

    public record Person(String name, int age) {}

    public static void test() {
        Person person = new Person("zhangsan", 18);
        System.out.println("name: " + person.name() + ", age: " + person.age());

        ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();
    }

}
