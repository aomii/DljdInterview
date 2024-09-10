package com.bjpowernode.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CatTest001 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        /*executorService.execute(() -> {
            System.out.println("任务开始..................");
            int a = 10 / 0;
            System.out.println("任务结束..................");
        });*/

        executorService.submit(() -> {
            System.out.println("任务开始..................");
            int a = 10 / 0;
            System.out.println("任务结束..................");
        });

        executorService.shutdown();
    }
}