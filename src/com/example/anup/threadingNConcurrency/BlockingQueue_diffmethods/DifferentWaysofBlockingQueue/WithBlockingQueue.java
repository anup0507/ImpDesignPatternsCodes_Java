package com.example.anup.threadingNConcurrency.BlockingQueue_diffmethods.DifferentWaysofBlockingQueue;

import java.util.concurrent.*;

public class WithBlockingQueue implements Callable {

    final int count=Integer.MAX_VALUE>>10;
    final int LIMIT= 10;
    public final BlockingQueue blockingQueue_imp=new ArrayBlockingQueue(LIMIT);

    int threadCount;
    public WithBlockingQueue(int threadCount){
        this.threadCount = threadCount;
    }
    @Override
    public Object call() throws Exception {
        final Producer_wb producer=new Producer_wb();
        final Consumer_wb consumer=new Consumer_wb();
        final long startTime=System.nanoTime();
        ExecutorService service= Executors.newFixedThreadPool(threadCount);
        for(int i=0;i<(threadCount/2);i++)
        {
            service.submit(()->{
                for(int j=0;j<100;j++)
                {
                    producer.produce(j);
                }
            });
        }
        for(int i=0;i<(threadCount/2);i++)
        {
            service.submit(()->{
                for(int j=0;j<100;j++)
                {
                    consumer.consume();
                }
            });
        }
        service.shutdown();
        if(!service.awaitTermination(40,java.util.concurrent.TimeUnit.SECONDS))
        {
            service.shutdownNow();

        }
        final long endTime=System.nanoTime();
        System.out.println("Time taken in seconds from Blocking Queue: "+(endTime-startTime)*(1e-9));

        return null;
    }
    public class Producer_wb{
        public void produce(int input){
            try
            {
                blockingQueue_imp.offer(input,1000, TimeUnit.MILLISECONDS);
           //     System.out.println("Producer Produced : "+input + " List size : "+blockingQueue_imp.size() + " Thread id: "+Thread.currentThread().getName());
            }
            catch (InterruptedException e)
            {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }
    }
    public class Consumer_wb{
        public void consume(){
            try {
                int val = (int) blockingQueue_imp.poll(1000, TimeUnit.MILLISECONDS);
               // System.out.println("Consumer Consumed : " + val + " List size : " + blockingQueue_imp.size()+ " Thread id: "+Thread.currentThread().getName());
            }
            catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }
    }
}
