package com.example.anup.threadingNConcurrency.BlockingQueue_diffmethods.DifferentWaysofBlockingQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WaitNotifyQueue implements Callable {
    int threadCount;
    public final List<Integer> list=new ArrayList<>();
    final int count=Integer.MAX_VALUE>>10;
    //final int count=100;
    final int LIMIT= 10;
    public WaitNotifyQueue(int threadCount){
        this.threadCount = threadCount;
    }

    @Override
    public Object call() throws Exception {
        final Producer_wn producer=new Producer_wn();
        final Consumer_wn consumer=new Consumer_wn();
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
        System.out.println("Time taken in seconds: "+(endTime-startTime)*(1e-9));
        return null;
    }

    public class Producer_wn  {

        public void produce(int input) throws InterruptedException {
            synchronized (list)
            {
                while(list.size()>=LIMIT && !Thread.currentThread().isInterrupted())
                {
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                if(list.size()<LIMIT)
                    list.add(input);
              //  Thread.sleep(1000);
             //   System.out.println("producer Produced : " + input + " List size : " + list.size() + " Thread id: " + Thread.currentThread().getName());
                list.notify();
            }
        }
    }

    public class Consumer_wn  {
        public void consume() throws InterruptedException {
            synchronized (list) {
                while (list.size() <= 0 && !Thread.currentThread().isInterrupted()) {
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                int val = list.removeFirst();
           //     Thread.sleep(1000);
            //    System.out.println("Consumer Consumed : " + val + " List size : " + list.size()+ " Thread id: "+Thread.currentThread().getName());
                list.notify();
            }
        }
    }

}
