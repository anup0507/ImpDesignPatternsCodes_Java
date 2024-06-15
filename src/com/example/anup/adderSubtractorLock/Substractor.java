package com.example.anup.adderSubtractorLock;

import java.util.concurrent.locks.Lock;

public class Substractor implements Runnable{
    private Count count;
    private Lock lock;
    //      int   i

    public Substractor(Count count,Lock lock) {
        this.count = count;
        this.lock = lock;
    }

    @Override
    public void run() {
        //lock.lock();
        for (int i = 1; i <= 1000; ++i) {
            lock.lock();
            count.addCount(-i);
            lock.unlock();
        }
      //  lock.unlock();
    }
}
