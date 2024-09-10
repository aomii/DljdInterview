package com.bjpowernode.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TaskOrderWithCondition {

    private static final Lock lock = new ReentrantLock();
    private static final Condition condition = lock.newCondition();

    private static volatile int currentTask = 0; // 0: Task A, 1: Task B, 2: Task C

    public static void main(String[] args) {
        Thread threadA = new Thread(TaskOrderWithCondition::taskA);
        Thread threadB = new Thread(TaskOrderWithCondition::taskB);
        Thread threadC = new Thread(TaskOrderWithCondition::taskC);

        threadA.start();
        threadB.start();
        threadC.start();
    }

    private static void taskA() {
        lock.lock();
        try {
            if (currentTask != 0) {
                condition.await(); // 等待
            }
            System.out.println("Task A is running...");
            // 模拟任务A的执行
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Task A finished.");
            currentTask = 1;
            condition.signalAll(); // 通知其他线程
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private static void taskB() {
        lock.lock();
        try {
            if (currentTask != 1) {
                condition.await(); // 等待
            }
            System.out.println("Task B is running...");
            // 模拟任务B的执行
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Task B finished.");
            currentTask = 2;
            condition.signalAll(); // 通知其他线程
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private static void taskC() {
        lock.lock();
        try {
            if (currentTask != 2) {
                condition.await(); // 等待
            }
            System.out.println("Task C is running...");
            // 模拟任务C的执行
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Task C finished.");
            currentTask = 3;
            condition.signalAll(); // 通知其他线程
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}