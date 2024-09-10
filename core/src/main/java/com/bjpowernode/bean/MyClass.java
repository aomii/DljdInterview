package com.bjpowernode.bean;

public class MyClass {

    private int id;
    private byte[] bytes = new byte[1024 * 1024]; //1mb

    public MyClass() {
    }

    public MyClass(int id) {
        this.id = id;
    }
}
