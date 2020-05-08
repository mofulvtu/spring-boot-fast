package com.liuzg.base.function;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Java8Predicate {


    @Test
    public void testPredicate() {

        //============ Predicate ===========
        Predicate<Integer> predicate1 = n -> n > 0;
        boolean test = predicate1.test(1);
        System.out.println(test);

        Predicate<String> predicate2 = s -> s.length() > 0;
        Predicate<String> predicate3 = Objects::nonNull;

        boolean result1 = predicate2.and(predicate3).test("Java");
        System.out.println(result1);

        Predicate<String> predicate4 = s -> s.length() < 5;
        boolean result2 = predicate3.or(predicate4).test("Java");
        System.out.println(result2);

        boolean test1 = predicate1.negate().test(1);
        System.out.println(test1);

        boolean test2 = Predicate.isEqual("Java").test("Java");
        System.out.println(test2);
        Predicate<String> predicate5 = s -> s.contains("h");
        List<String> strList = Arrays.asList("Java", "Python", "C++", "Php");

        List<String> collect = strList.stream().filter(predicate4.and(predicate5)).collect(Collectors.toList());

        System.out.println(collect);


    }
}
