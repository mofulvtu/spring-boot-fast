package com.liuzg.base.function;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Java8Consumer {

    @Test
    public void testConsumer() {

        Consumer<String> consumer1 = System.out::println;
        consumer1.accept("Hello! Consumer.");

        List<String> strList = Arrays.asList("Java", "Python", "C++", "Php");
        strList.forEach(consumer1);

        Consumer<Integer> consumer2 = i -> System.out.println("数值：" + i);
        Consumer<Integer> consumer3 = i -> System.out.println("相乘：" + (i * i));
        Consumer<Integer> consumer4 = i -> System.out.println("相加：" + (i + i));
        consumer2.andThen(consumer3).andThen(consumer4).accept(3);
    }
}
