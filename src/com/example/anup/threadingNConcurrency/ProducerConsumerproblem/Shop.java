package com.example.anup.threadingNConcurrency.ProducerConsumerproblem;

import java.util.concurrent.Semaphore;

public class Shop {
    private int size;
    private Semaphore producerSemaphore=new Semaphore(5);
    private Semaphore consumerSemaphore=new Semaphore(0);
    public Shop()
    {
        size=0;
    }
    public void produce () throws InterruptedException {
        producerSemaphore.acquire();
        if(size<5)
        {
            Thread.sleep(500);
            if(size<5)
            {
                size++;
                System.out.println("Produced 1 item. Total items in shop : " + size);
            }

        }
        consumerSemaphore.release();
    }

    public void consume() throws InterruptedException {
        consumerSemaphore.acquire();
        if(size>0)
        {
            Thread.sleep(1000);
            if(size>0)
            {
                size--;
                System.out.println("Consumed 1 item. Total items in shop : " + size);
            }


        }
        producerSemaphore.release();
    }

}
