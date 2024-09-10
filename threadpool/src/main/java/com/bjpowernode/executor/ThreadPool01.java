package com.bjpowernode.executor;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPool01 {

    public static void main(String[] args) {
        //基于Executor框架实现线程池
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                8,
                16,
                60,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(1024),
                //Executors.defaultThreadFactory(),
                //Executors.privilegedThreadFactory(),
                new MyThreadFactory("pay-thread-pool-"),
                new ThreadPoolExecutor.AbortPolicy()
        );

        //创建线程池后，初始化一个核心线程
        threadPoolExecutor.prestartCoreThread();

        //创建线程池后，初始化所有的核心线程
        threadPoolExecutor.prestartAllCoreThreads();

        //设置核心线程在空闲超时后是否允许销毁，true表示允许销毁
        threadPoolExecutor.allowCoreThreadTimeOut(true);

        threadPoolExecutor.execute(() -> {
            System.out.println("任务执行......" + Thread.currentThread().getName());
        });

        threadPoolExecutor.shutdown();
    }

    static class MyThreadFactory implements ThreadFactory {

        private final AtomicInteger threadNumber = new AtomicInteger(1); //线程编号
        private final String namePrefix; //线程名称的前缀

        public MyThreadFactory(String namePrefix) {
            this.namePrefix = namePrefix;
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r, namePrefix + threadNumber.getAndIncrement());
            if (t.isDaemon())
                t.setDaemon(false);
            if (t.getPriority() != Thread.NORM_PRIORITY)
                t.setPriority(Thread.NORM_PRIORITY);
            return t;
        }
    }
}
