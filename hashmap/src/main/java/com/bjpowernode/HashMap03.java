package com.bjpowernode;

public class HashMap03 {

    public static void main(String[] args) {

        Thread t1 = new Thread(new HashMapRunnable());
        Thread t2 = new Thread(new HashMapRunnable());
        Thread t3 = new Thread(new HashMapRunnable());
        Thread t4 = new Thread(new HashMapRunnable());
        Thread t5 = new Thread(new HashMapRunnable());

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}