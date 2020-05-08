package com.liuzg.base;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Java8Lambda {

    public static void main(String[] args) {

        Java8Lambda test = new Java8Lambda();
        Calculation add = (int a, int b) -> a + b;
        Calculation reduce = (a, b) -> a - b;
        Calculation multiply = (a, b) -> {
            return a * b;
        };
        Calculation divide = (a, b) -> a / b;

        System.out.println("10 + 5 = " + test.operate(10, 5, add));
        System.out.println("10 - 5 = " + test.operate(10, 5, reduce));
        System.out.println("10 x 5 = " + test.operate(10, 5, multiply));
        System.out.println("10 / 5 = " + test.operate(10, 5, divide));

        List<String> list = Arrays.asList("jack", "peter", "james", "tom");
        //排序
        //java8之前实现
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        //java8 Lambda实现
        Collections.sort(list,(String o1,String o2)->{
            return o1.compareTo(o2);
        });
        //精简
        Collections.sort(list,(String o1,String o2)->o1.compareTo(o2));
        //再精简
        //大括号、入参类型、关键字return 都可以省掉，精简的这些Java 编译器都可以根据类型推断机制推导得出
        list.sort((o1, o2) -> o1.compareTo(o2));

        //变量作用域
        int num1 = 10;
        final int num2 = 10;
        Calculation calculation = (a, b) -> (a + b + num1 + num2);
        calculation.operation(5, 5);
        System.out.println("结果===" + calculation.operation(5, 5));

        //num1 = 20; 编译报错

        int a = 5;
        //Comparator<Integer> comparator = (a, b) -> Integer.compare(a, b);  //a重复，编译报错
    }
    interface Calculation {
        int operation(int a, int b);
    }
    private int operate(int a, int b, Calculation calculation) {
        return calculation.operation(a, b);
    }
}
