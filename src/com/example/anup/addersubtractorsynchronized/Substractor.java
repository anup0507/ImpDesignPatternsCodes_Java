package com.example.anup.addersubtractorsynchronized;

import java.util.concurrent.locks.Lock;

public class Substractor implements Runnable{
    private Count count;

    public Substractor(Count count) {
        this.count = count;
    }

    @Override
    public void run() {
        synchronized (count)
        {
            for (int i = 1; i <= 1000; ++i) {

                count.addCount(-i);

            }
        }
    }
}
