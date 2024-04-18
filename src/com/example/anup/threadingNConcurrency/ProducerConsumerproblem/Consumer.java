package com.example.anup.threadingNConcurrency.ProducerConsumerproblem;

import java.util.concurrent.Semaphore;

public class Consumer implements Runnable{
    private final Shop shop;

    public Consumer(Shop shop){
        this.shop = shop;

    }
    @Override
    public void run() {
        while (true)
        {
            try {
                shop.consume();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
