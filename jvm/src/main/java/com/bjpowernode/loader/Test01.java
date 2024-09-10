package com.bjpowernode.loader;

import com.bjpowernode.model.*;

public class Test01 { // java.lang.Class

    //常量
    public static final int a = 123;

    //类变量
    public static int b = 222;//0

    public static String str = "sdfsdf"; //null

    //实例变量
    public int abc;

    // -XX:+TraceClassLoading 监控类的加载
    public static void main(String[] args) {
        User user = new User();
        user.working();
        System.out.println(b);

        Order order = new Order();
    }
}
