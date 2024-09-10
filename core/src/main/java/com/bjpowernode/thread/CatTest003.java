package com.bjpowernode.thread;

public class CatTest003 {

    public static final Object monitor = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread main = Thread.currentThread();

        new Thread(() -> {
            System.out.println(main.getState());
        }).start();

        Thread.sleep(10000);
    }
}
