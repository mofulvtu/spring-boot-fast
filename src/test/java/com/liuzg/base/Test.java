package com.liuzg.base;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<String> a = new ArrayList<>();
        test(a);
        System.out.println(a.size());
    }

    private static void test(List<String> a) {
        a.add("123");
    }
}
