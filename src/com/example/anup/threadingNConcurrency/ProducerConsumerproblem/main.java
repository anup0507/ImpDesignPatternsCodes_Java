package com.example.anup.threadingNConcurrency.ProducerConsumerproblem;

import java.util.concurrent.Semaphore;

public class main {

    public  static  void main(String[] args)
    {
        Shop shop=new Shop();

        Thread t1=new Thread(new Producer(shop));
        Thread t4=new Thread(new Consumer(shop));
        Thread t5=new Thread(new Consumer(shop));
        Thread t6=new Thread(new Consumer(shop));
        Thread t2=new Thread(new Producer(shop));
        Thread t3=new Thread(new Producer(shop));

        t1.start();
        t4.start();
        t5.start();
        t6.start();
        t2.start();
        t3.start();

    }

}
