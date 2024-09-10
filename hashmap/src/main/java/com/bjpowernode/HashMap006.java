package com.bjpowernode;

import java.util.concurrent.ConcurrentHashMap;

public class HashMap006 {

    public static void main(String[] args) {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<String, String>();
        map.put("name", "Cat");
        map.put("phone", "13700000000");
        map.put("address", "Beijing");
    }
}
