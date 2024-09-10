package com.bjpowernode.threadlocal;

public class CatThreadLocal001 {

    public static final ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        try {
            //main线程
            threadLocal.set(123);

            Integer i = threadLocal.get();

            System.out.println(i);

            System.out.println(32 / 3);
        } finally {
            threadLocal.remove();
        }
    }
}
