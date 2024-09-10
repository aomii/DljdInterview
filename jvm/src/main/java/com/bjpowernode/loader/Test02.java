package com.bjpowernode.loader;

public class Test02 {

    // 静态常量  ==准备
    public static final String staticConstantField = "静态常量";

    // 静态变量 ==准备阶段赋值为 null，初始化阶段赋值为 静态变量
    public static String staticField = "静态变量";

    // 变量 == 创建对象的时候赋值
    public String field = "变量";

    // 静态初始化块 ==初始化阶段执行
    static {
        System.out.println(staticConstantField);
        System.out.println(staticField);
        System.out.println("静态初始化块");
    }

    // 初始化块 == 创建对象的时候执行
    {
        System.out.println(field);
        System.out.println("初始化块");
    }

    // 构造器 == 创建对象的时候执行
    public Test02() {
        System.out.println("构造器");
    }

    // java Test02
    public static void main(String[] args) {
        new Test02();

        // 1、rt.jar charset.jar
        // 2、InitialOrderTest
    }
}
