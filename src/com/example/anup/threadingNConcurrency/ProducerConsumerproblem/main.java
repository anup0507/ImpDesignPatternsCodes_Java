package com.example.anup.threadingNConcurrency.ProducerConsumerproblem;

import java.util.concurrent.Semaphore;

public class main {

    public  static  void main(String[] args)
    {
        Shop shop=new Shop();
        int threadCount = 10;
        System.out.println("Using " + threadCount + " threads.");
        Thread t1=new Thread(new Producer(shop));
     //   Thread t4=new Thread(new Consumer(shop));
        Thread t5=new Thread(new Consumer(shop));
      //  Thread t6=new Thread(new Consumer(shop));
       // Thread t2=new Thread(new Producer(shop));
       // Thread t3=new Thread(new Producer(shop));

        t1.start();
        //t4.start();
        t5.start();
        //t6.start();
        //t2.start();
        //t3.start();

        /*Thread th[]=new Thread[threadCount];

        for(int i=0;i<(threadCount/2);i++)
        {
            th[i]=new Thread(new Producer(shop));
            th[i].start();
        }
        for(int i=(threadCount/2);i<threadCount;i++)
        {
            th[i]=new Thread(new Consumer(shop));
            th[i].start();
        }
        for(int i=0;i<threadCount;i++)
        {
            try {
                th[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
*/
    }

}
