package com.bjpowernode.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 解读代码
 * 定义 CyclicBarrier:
 * barrierAtoB = new CyclicBarrier(2); 创建了一个屏障，需要2个线程到达屏障点后才会释放。
 * barrierBtoC = new CyclicBarrier(2); 同样创建了一个屏障，同样需要2个线程到达屏障点后才会释放。
 * 启动线程:
 * Thread threadA = new Thread(TaskOrderWithCyclicBarrier::taskA);
 * Thread threadB = new Thread(TaskOrderWithCyclicBarrier::taskB);
 * Thread threadC = new Thread(TaskOrderWithCyclicBarrier::taskC);
 * 然后启动这三个线程：threadA.start();, threadB.start();, threadC.start();
 * Task A:
 * 输出信息表示任务A开始执行。
 * 模拟任务A的执行，这里用了1秒钟的休眠。
 * 任务A执行完毕后，调用 barrierAtoB.await();，等待另一个线程到达屏障点。
 * Task B:
 * 首先等待 barrierAtoB.await();，确保任务A已完成。
 * 输出信息表示任务B开始执行。
 * 模拟任务B的执行，这里用了1秒钟的休眠。
 * 任务B执行完毕后，调用 barrierBtoC.await();，等待另一个线程到达屏障点。
 * Task C:
 * 首先等待 barrierBtoC.await();，确保任务B已完成。
 * 输出信息表示任务C开始执行。
 * 模拟任务C的执行，这里用了1秒钟的休眠。
 * 任务C执行完毕后，不再需要等待任何屏障点。
 * 工作流程
 * 任务A首先开始执行，模拟执行后调用 barrierAtoB.await() 等待任务B的到来。
 * 任务B在任务A完成后才开始执行，执行完成后调用 barrierBtoC.await() 等待任务C的到来。
 * 任务C最后开始执行，在任务B完成后开始执行。
 * 通过这种方式，我们确保了任务按照 A -> B -> C 的顺序依次执行。每个任务都在前一个任务完成后才开始执行，这正是 CyclicBarrier 帮助我们实现的任务顺序执行逻辑。
 */

public class TaskOrderWithCyclicBarrier {

    private static final CyclicBarrier barrierAtoB = new CyclicBarrier(2);
    private static final CyclicBarrier barrierBtoC = new CyclicBarrier(2);

    public static void main(String[] args) {
        Thread threadA = new Thread(TaskOrderWithCyclicBarrier::taskA);
        Thread threadB = new Thread(TaskOrderWithCyclicBarrier::taskB);
        Thread threadC = new Thread(TaskOrderWithCyclicBarrier::taskC);

        threadA.start();
        threadB.start();
        threadC.start();
    }

    private static void taskA() {
        System.out.println("Task A is running...");
        // 模拟任务A的执行
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task A finished.");
        try {
            barrierAtoB.await(); // 等待
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    private static void taskB() {
        try {
            barrierAtoB.await(); // 等待
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("Task B is running...");
        // 模拟任务B的执行
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task B finished.");
        try {
            barrierBtoC.await(); // 等待
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    private static void taskC() {
        try {
            barrierBtoC.await(); // 等待
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
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