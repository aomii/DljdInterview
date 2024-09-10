package com.bjpowernode.threadlocal;

import com.bjpowernode.bean.MyClass;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 使用ThreadLocal内存泄漏
 *
 */
public class CatThreadLocal003 {

    // -Xms25m -Xmx25m
    public static void main(String[] args) {
        //创建一个线程池
        ExecutorService executorService = Executors.newFixedThreadPool(30);

        for (int i = 0; i < 30; i++) {
            executorService.execute(() -> {
                doSomeThing();
            });
            try {
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void doSomeThing() {
        ThreadLocal<MyClass> threadLocal = new ThreadLocal<>();
        try {
            MyClass myClass = new MyClass(); // 1mb
            threadLocal.set(myClass);
            System.out.println(Thread.currentThread().getName());
        } finally {
            // 解决内存泄露的核心
            threadLocal.remove();
        }
    }
}