package com.bjpowernode.thread;

public class CatTest002 {

    public static final Object monitor = new Object();

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            synchronized (monitor) {
                monitor.notifyAll();
            }
        }).start();


        synchronized (monitor) {
            monitor.wait();
            monitor.wait();
        }
    }
}
