package com.bjpowernode.hashmap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CatHashMap005 {

    public static final Map<Object, Object> map = Collections.synchronizedMap(new HashMap<Object, Object>());

    ConcurrentHashMap mm;

    Hashtable hashtable;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 5000; i++) {
                    map.put(new Integer(i), i);
                }
                System.out.println("-----t1 执行OK");
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 5000; i++) {
                    map.put(new Integer(i), i);
                }
                System.out.println("-----t2 执行OK");
            }
        };

        //------------------------------------------

        Thread t3 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 5000; i++) {
                    System.out.println(map.get(new Integer(i)));
                }
                System.out.println("-----t3 执行OK");
            }
        };

        Thread t4 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 5000; i++) {
                    System.out.println(map.get(new Integer(i)));
                }
                System.out.println("-----t4 执行OK");
            }
        };

        t1.start();
        t2.start();

        t3.start();
        t4.start();
    }
}