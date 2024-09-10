package com.bjpowernode.thread;

import java.util.concurrent.*;

public class CatTest007 {

    private static final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,
            1,
            0L,
            TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(1024),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.DiscardOldestPolicy());

    private static ExecutorService executorService = Executors.newSingleThreadExecutor();

    public static void main(String[] args) throws Exception {

        // t1线程
        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " t1执行");
        }, "t1");

        // t2线程
        Thread t2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " t2执行");
        }, "t2");

        // t3线程
        Thread t3 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " t3执行");
        }, "t3");

        threadPoolExecutor.execute(t1);
        threadPoolExecutor.execute(t2);
        threadPoolExecutor.execute(t3);

        threadPoolExecutor.shutdown();
    }
}