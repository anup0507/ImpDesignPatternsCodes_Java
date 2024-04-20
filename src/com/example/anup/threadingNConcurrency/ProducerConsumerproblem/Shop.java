package com.example.anup.threadingNConcurrency.ProducerConsumerproblem;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;

public class Shop {
    private int size=10;
    private LinkedList<Integer> list=new LinkedList<>();

    private Semaphore producerSemaphore=new Semaphore(5);
    private Semaphore consumerSemaphore=new Semaphore(0);
    public Shop()
    {
        size=0;
    }
    public void produce () throws InterruptedException {
        producerSemaphore.acquire();
        if(list.size()<5)
        {
            Thread.sleep(1000);
            if(list.size()<5)
            {
                size++;
                list.add(1);
                System.out.println("Produced 1 item. Total items in shop : " + list.size() + " and size="+size+ " Thread id: "+Thread.currentThread().getName());
            }

        }
        consumerSemaphore.release();
    }

    public void consume() throws InterruptedException {
        consumerSemaphore.acquire();
        if(list.size()>0)
        {
            Thread.sleep(1000);
            if(list.size()>0)
            {
                size--;
                list.removeFirst();
                System.out.println("Consumed 1 item. Total items in shop : " + list.size() +" and size="+size+ " Thread id: "+Thread.currentThread().getName());
            }
        }
        producerSemaphore.release();
    }

}
