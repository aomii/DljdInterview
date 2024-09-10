package com.bjpowernode.thread;

public class TaskOrderExample {

    private static final Object lock = new Object();
    private static boolean taskACompleted = false;
    private static boolean taskBCompleted = false;

    public static void main(String[] args) {
        Thread threadA = new Thread(TaskOrderExample::taskA);
        Thread threadB = new Thread(TaskOrderExample::taskB);
        Thread threadC = new Thread(TaskOrderExample::taskC);

        threadA.start();
        threadB.start();
        threadC.start();
    }

    private static void taskA() {
        synchronized (lock) {
            System.out.println("Task A is running...");
            // 模拟任务A的执行
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Task A finished.");
            taskACompleted = true;
            lock.notifyAll(); // 通知其他线程
        }
    }

    private static void taskB() {
        synchronized (lock) {
            while (!taskACompleted) {
                try {
                    lock.wait(); // 等待任务A完成
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Task B is running...");
            // 模拟任务B的执行
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Task B finished.");
            taskBCompleted = true;
            lock.notifyAll(); // 通知其他线程
        }
    }

    private static void taskC() {
        synchronized (lock) {
            while (!taskBCompleted) {
                try {
                    lock.wait(); // 等待任务B完成
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Task C is running...");
            // 模拟任务C的执行
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Task C finished.");
        }
    }
}