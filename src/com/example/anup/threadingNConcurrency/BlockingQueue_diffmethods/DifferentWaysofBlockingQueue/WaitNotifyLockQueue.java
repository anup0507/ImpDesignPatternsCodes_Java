package com.example.anup.threadingNConcurrency.BlockingQueue_diffmethods.DifferentWaysofBlockingQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class WaitNotifyLockQueue implements Callable {
     int threadCount;
     public final List<Integer> list=new ArrayList<>();
    // final int count=Integer.MAX_VALUE>>10;
     final int count=20;
     final int LIMIT= 10;
     ReentrantLock lock=new ReentrantLock(false);
     Condition notFull=lock.newCondition();
     Condition notEmpty=lock.newCondition();

     public WaitNotifyLockQueue(int threadCount){
         this.threadCount = threadCount;
     }
    @Override
    public Object call() throws Exception {
         final Producer_wnl producer=new Producer_wnl();
         final Consumer_wnl consumer=new Consumer_wnl();
         final long startTime=System.nanoTime();
        ExecutorService service= Executors.newFixedThreadPool(threadCount);
        for(int i=0;i<(threadCount/2);i++)
        {
            service.submit(()->{
                for(int j=0;j<count;j++)
                {
                    try {
                        producer.produce(j);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }
        for(int i=0;i<(threadCount/2);i++)
        {
            service.submit(()->{
                for(int j=0;j<count;j++)
                {
                    try {
                        consumer.consume();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }
        service.shutdown();
        if(!service.awaitTermination(1000,java.util.concurrent.TimeUnit.SECONDS))
        {
            service.shutdownNow();

        }
        final long endTime=System.nanoTime();
        System.out.println("Time taken in seconds from Wait n Notify Lock Queue: "+(endTime-startTime)*(1e-9));

        return null;
    }

    public class Producer_wnl{
        public void produce(int input) throws InterruptedException {
            lock.lock();
            while(list.size()==LIMIT && !Thread.currentThread().isInterrupted())
            {
                try {
                    notFull.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Thread.sleep(1000);
            list.add(input);

            System.out.println("Producer Produced : "+input + " List size : "+list.size() + " Thread id: "+Thread.currentThread().getName());

            notEmpty.signal();
            lock.unlock();
        }
    }

    public class Consumer_wnl{
         public void consume() throws InterruptedException {
             lock.lock();
                while(list.size()==0 && !Thread.currentThread().isInterrupted())
                {
                    try {
                        notEmpty.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Thread.sleep(1000);
                int val = list.remove(0);
                System.out.println("Consumer Consumed : "+val + " List size : "+list.size() + " Thread id: "+Thread.currentThread().getName());

                notFull.signal();
                lock.unlock();

         }


    }



}
