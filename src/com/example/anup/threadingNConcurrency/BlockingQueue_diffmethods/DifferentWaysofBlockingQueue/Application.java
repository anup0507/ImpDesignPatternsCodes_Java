package com.example.anup.threadingNConcurrency.BlockingQueue_diffmethods.DifferentWaysofBlockingQueue;

public class Application {
    public static void main(String[] args) throws Exception {
        int threadCount = 10;
        System.out.println("Using " + threadCount + " threads.");
//        final WaitNotifyQueue waitNotifyQueue = new WaitNotifyQueue(threadCount);
//        waitNotifyQueue.call();
//        System.gc();
        final WaitNotifyLockQueue waitNotifyLockQueue = new WaitNotifyLockQueue(threadCount);
        waitNotifyLockQueue.call();
//        System.gc();
//        final WithBlockingQueue withBlockingQueue = new WithBlockingQueue(threadCount);
//        withBlockingQueue.call();

    }
}
