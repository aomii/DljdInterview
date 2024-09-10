package com.bjpowernode;

import java.util.HashMap;
import java.util.Map;

public class HashMap01 {

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "Cat");
        map.put("name", "zhangsan");

        map.put(null, null);
        map.put("phone", "13700000000");
        map.put("age", 18);

        map.forEach((k, v) -> {
            System.out.println(k + " -- " + v);
        });
    }
}
