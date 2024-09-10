package com.bjpowernode.thread;

public class CatTest001 {

    public static void main(String[] args) throws InterruptedException {

        Thread.sleep(2000);

        Object t = new Object();
        synchronized (t) {
            t.wait(1000);
        }
    }
}
