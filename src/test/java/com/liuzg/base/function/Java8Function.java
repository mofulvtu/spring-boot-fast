package com.liuzg.base.function;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Java8Function {
    @Test
    public void testFunction() {
        Function<Integer, Integer> function1 = f -> f * 6;
        Integer apply1 = function1.apply(1);
        System.out.println(apply1);

        Function<Integer,Integer> function2 = f -> f + 1;

        Integer apply2 = function1.compose(function2).apply(2);
        System.out.println(apply2);

        Integer apply3 = function1.andThen(function2).apply(2);
        System.out.println(apply3);

        Function<Integer,Integer> function3 = Function.identity();
        function3.apply(5);

        // 将list转换成Map
        List<String> asList = Arrays.asList("Hello", "Java", "Function");
        Map<String, Integer> map = asList.stream().collect(Collectors.toMap(Function.identity(), String::length));
        System.out.println(map);
    }
}
