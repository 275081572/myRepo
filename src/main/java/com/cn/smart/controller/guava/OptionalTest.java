package com.cn.smart.controller.guava;

import com.google.common.base.Optional;

/**
 * TODO
 *
 * @author xuwei
 * @date 2023/4/13
 */

public class OptionalTest {

    public static void main(String[] args) {
        OptionalTest optionalTest = new OptionalTest();
        Integer value1 = null;
        Integer value2 = 10;
        Optional<Integer> a = Optional.fromNullable(value1);
        Optional<Integer> b = Optional.of(value2);

        System.out.println(optionalTest.sum(a, b));
    }

    public Integer sum(Optional<Integer> a, Optional<Integer> b) {
        System.out.println("a is present: " + a.isPresent());
        Integer value1 = a.or(new Integer(5));
        System.out.println("value1 is present: " + value1);
        Integer value2 = b.get();
        System.out.println("value2 is present: " + value2);

        return value1 + value2;
    }

}
