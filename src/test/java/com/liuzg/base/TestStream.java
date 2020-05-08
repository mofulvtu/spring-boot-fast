package com.liuzg.base;

import com.liuzg.service.FunctionInterfaceDemo;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class TestStream {

    private static final Logger logger = LoggerFactory.getLogger(TestStream.class);

    /**
     * Lambda 的使用，使用 Runnable 例子
     *
     * @throws InterruptedException
     */
    @Test
    public void createLambda() throws InterruptedException {
        // 使用 Lambda 之前
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("JDK8 之前的线程创建");
            }
        };
        new Thread(runnable).start();

        // 使用 Lambda 之后
        Runnable runnable1Jdk8 = () -> System.out.println("JDK8 之后的线程创建");
        new Thread(runnable1Jdk8).start();
        // 更加紧凑的方式
        new Thread(() -> System.out.println("JDK8 之后的线程创建")).start();
    }

    @Test
    public void functionLambdaTest() {
        FunctionInterfaceDemo demo = ((name, number) -> System.out.println("I want eat " + number + " " + name));
        demo.eat("apple", 2);
    }

    /**
     * 新的遍历方式
     */
    @Test
    public void foreachTest() {
        List<String> skills = Arrays.asList("java", "golang", "c++", "c", "python");
        // 使用 Lambda 之前
        for (String skill : skills) {
            System.out.print(skill + ",");
        }
        System.out.println();
        // 使用 Lambda 之后
        // 方式1,forEach+lambda
        skills.forEach((skill) -> System.out.print(skill + ","));
        System.out.println();
        // 方式2，forEach+方法引用
        skills.forEach(System.out::print);
    }

    @Test
    public void test() {
        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, String> backToString = toInteger.andThen(String::valueOf);

        backToString.apply("123");
    }

}
