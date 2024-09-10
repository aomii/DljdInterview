package com.bjpowernode.thread;

public class CatTest004 {

    public static final Object monitor = new Object();

    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            synchronized (monitor) {
                try {
                    monitor.wait(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        Thread.sleep(1000);

        synchronized (monitor) {
            System.out.println("获取锁...");
        }
    }
}
