package com.bjpowernode.thread;

public class CatTest006 {

    public static void main(String[] args) throws Exception {

        // t1线程
        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " 执行");
        }, "t1");

        // t2线程
        Thread t2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " 执行");
        }, "t2");

        // t3线程
        Thread t3 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " 执行");
        }, "t3");

        t1.start();
        t1.join();

        t2.start();
        t2.join();

        t3.start();
    }
}