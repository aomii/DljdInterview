package com.bjpowernode.hashmap;

import java.util.HashMap;
import java.util.Map;

public class CatHashMap004 {

    public static final Map<Object, Object> map = new HashMap<Object, Object>();

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

        //main线程休眠2秒，确保map数据put完成
        Thread.sleep(10000);

        for (Map.Entry<Object, Object> entry : map.entrySet()) {
            System.out.println("k = " + entry.getKey() + ", v = " + entry.getValue());
        }
    }
}