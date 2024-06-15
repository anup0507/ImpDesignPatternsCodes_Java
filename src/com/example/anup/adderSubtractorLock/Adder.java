package com.example.anup.adderSubtractorLock;

import java.util.concurrent.locks.Lock;

public class Adder implements Runnable {
    private Count count;
    private Lock lock;
    public Adder(Count c,Lock lock) {
        this.count=c;
        this.lock=lock;
    }

    @Override
    public void run() {
        //lock.lock();
        for(int i=1;i<=1000;i++)
        {
            lock.lock();
            count.addCount(i);
            lock.unlock();
        }
        //lock.unlock();
    }

}
