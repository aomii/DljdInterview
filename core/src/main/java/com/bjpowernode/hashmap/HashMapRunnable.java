package com.bjpowernode.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class HashMapRunnable implements Runnable {

    private static AtomicInteger atomicInteger = new AtomicInteger();

    private static Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    @Override
    public void run () {
        while (atomicInteger.get() < 1000000) {
            map.put(atomicInteger.get(), atomicInteger.get());
            atomicInteger.incrementAndGet();
        }
    }
}
