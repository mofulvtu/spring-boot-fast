package com.liuzg.base.function;

import org.junit.Test;

import java.util.concurrent.*;

public class Java8Thread {

    @Test
    public void testThread() {

        //创建线程Runnable方式
        //=========java8 以前=================
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable " + Thread.currentThread().getName());
            }
        };
        Thread thread1 = new Thread(runnable1);
        thread1.start();

        //=========java8 Lambda ================
        Runnable runnable2 = () -> System.out.println("Runnable " + Thread.currentThread().getName());
        Thread thread2 = new Thread(runnable2);
        thread2.start();

        //Thread
        new Thread(() -> System.out.println("Thread " + Thread.currentThread().getName())).start();


        //创建线程Callable方式
        //=========java8 以前=================
        ExecutorService task = Executors.newFixedThreadPool(3);
        Callable<Integer> callable1 = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("callable " + Thread.currentThread().getName());
                return 1;
            }
        };

        FutureTask<Integer> futureTask = new FutureTask<>(callable1);
        task.submit(futureTask);


        //=========java8 Lambda ================
        Callable<Integer> callable2 = () -> {
            System.out.println("callable " + Thread.currentThread().getName());
            return 1;
        };
        FutureTask<Integer> futureTask2 = new FutureTask<>(callable2);
        task.submit(futureTask2);

        //Callable 再简化
        FutureTask<Integer> futureTask3 = new FutureTask<>(() -> {
            System.out.println("callable " + Thread.currentThread().getName());
            return 1;
        });
        task.submit(futureTask3);


        try {
            System.out.println("callable value1：" + futureTask.get());
            System.out.println("callable value2：" + futureTask2.get());
            System.out.println("callable value3：" + futureTask3.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        //关闭线程池
        task.shutdown();
    }
}
