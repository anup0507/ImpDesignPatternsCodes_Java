package com.example.anup.threadingNConcurrency.ProducerConsumerproblem;

import java.util.concurrent.Semaphore;

public class Producer implements Runnable{
    private final Shop shop;
    public Producer(Shop shop){
        this.shop = shop;

    }
    @Override
    public void run() {
        while(true)
        {
            try {
                shop.produce();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
