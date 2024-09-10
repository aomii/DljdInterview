package com.bjpowernode.thread;

import java.util.concurrent.CountDownLatch;

public class CatTest008 {

    /** 用于判断t1线程是否执行，倒计时设置为1，执行后减1 */
    private static final CountDownLatch countDownLatch1 = new CountDownLatch(1);

    /** 用于判断t2线程是否执行，倒计时设置为1，执行后减1 */
    private static final CountDownLatch countDownLatch2 = new CountDownLatch(1);

    public static void main(String[] args) throws Exception {

        // t1线程
        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " 执行");
            countDownLatch1.countDown(); // -1
        }, "t1");

        // t2线程
        Thread t2 = new Thread(() -> {
            try {
                countDownLatch1.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " 执行");
            countDownLatch2.countDown();
        }, "t2");

        // t3线程
        Thread t3 = new Thread(() -> {
            try {
                countDownLatch2.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " 执行");
        }, "t3");

        t1.start();
        t2.start();
        t3.start();
    }
}