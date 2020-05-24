package com.liuzg.base;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class JavaTest {

    @Test
    public void testValue() {
        List<String> a = new ArrayList<>();
        test(a);
        System.out.println(a.size());
    }

    private static void test(List<String> a) {
        a.add("123");
    }
    //Java是值传递，a是引用类型，会将此引用地址传递给方法，如果在方法中没有改变地址，只是赋值，则原地址指向的内存发生变化；
    // 如果在方法中重新创建的新地址，比如new一个新对象，则a的地址指向新的内存区域，无论是否变化，都与传递进来的地址无关。


    @Test
    public void testValue2() {
        List<String> a = new ArrayList<>();
        test2(a);
        System.out.println(a.size());
    }

    private static void test2(List<String> a) {
        a = new ArrayList<>();
        a.add("123");
    }
}
