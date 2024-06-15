package com.example.anup.addersubtractorsynchronized;

import java.util.concurrent.locks.Lock;

public class Adder implements Runnable {
    private Count count;

    public Adder(Count c) {
        this.count=c;

    }

    @Override
    public void run() {
        synchronized (count){
            for(int i=1;i<=1000;i++)
            {
                count.addCount(i);
            }
        }
    }

}
