package com.bjpowernode;

import java.util.HashMap;

public class HashMap02 {

    public static final HashMap<String, String> map = new HashMap<String, String>();

    public static void main(String[] args) throws InterruptedException {
        //t1线程
        Thread t1 = new Thread() {
            public void run() {
                for (int i = 0; i < 50; i++) { // 50
                    map.put(String.valueOf(i), String.valueOf(i));
                }
            }
        };

        //t2线程
        Thread t2 = new Thread() {
            public void run() {
                for (int j = 50; j < 100; j++) { // 50
                    map.put(String.valueOf(j), String.valueOf(j));
                }
            }
        };

        t1.start();
        t2.start();

        //main线程休眠3秒，确保map数据put完成
        Thread.sleep(3000);

        map.forEach((k, v) -> {
            System.out.println(k + " -- " + v);
        });
    }
}
