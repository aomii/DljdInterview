package com.bjpowernode.order;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {

    public static void main(String[] args) throws Exception {

        ExecutorService executorService = Executors.newFixedThreadPool(300);

        while (true) {
            for (int i=0; i<300; i++) {
                executorService.submit(() -> {
                    Orders orders = new Orders();
                    System.out.println("下单：" + System.currentTimeMillis());
                });
            }
            Thread.sleep(1000L);
        }
    }
}