package com.bjpowernode.thread;

import java.util.concurrent.Semaphore;

public class TaskOrderWithSemaphore {

    private static final Semaphore semaphoreA = new Semaphore(1); // 1 permit for task A to start immediately
    private static final Semaphore semaphoreB = new Semaphore(0); // 0 permits for task B initially
    private static final Semaphore semaphoreC = new Semaphore(0); // 0 permits for task C initially

    public static void main(String[] args) {
        Thread threadA = new Thread(TaskOrderWithSemaphore::taskA);
        Thread threadB = new Thread(TaskOrderWithSemaphore::taskB);
        Thread threadC = new Thread(TaskOrderWithSemaphore::taskC);

        threadA.start();
        threadB.start();
        threadC.start();
    }

    private static void taskA() {
        try {
            semaphoreA.acquire(); // Wait until the semaphore has a permit
            System.out.println("Task A is running...");
            // 模拟任务A的执行
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Task A finished.");
            semaphoreB.release(); // Release a permit for task B
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void taskB() {
        try {
            semaphoreB.acquire(); // Wait until the semaphore has a permit
            System.out.println("Task B is running...");
            // 模拟任务B的执行
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Task B finished.");
            semaphoreC.release(); // Release a permit for task C
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void taskC() {
        try {
            semaphoreC.acquire(); // Wait until the semaphore has a permit
            System.out.println("Task C is running...");
            // 模拟任务C的执行
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Task C finished.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}