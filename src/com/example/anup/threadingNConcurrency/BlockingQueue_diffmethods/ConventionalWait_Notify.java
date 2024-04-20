package com.example.anup.threadingNConcurrency.BlockingQueue_diffmethods;

import com.example.anup.threadingNConcurrency.ProducerConsumerproblem.Producer;

import java.util.LinkedList;

public class ConventionalWait_Notify  {
    static final int LIMIT=100;
    static LinkedList<Integer> list=new LinkedList<>();
    static class Producer{
        public void produce(int i) throws InterruptedException {
            synchronized (list)
            {
                while(list.size()==LIMIT && !Thread.currentThread().isInterrupted())
                {
                    try
                    {
                        list.wait();
                        System.out.println("Producer waiting ,Thread id: "+Thread.currentThread().getName());
                    }
                    catch (InterruptedException e)
                    {
                        Thread.currentThread().interrupt();
                    }

                }
                list.add(i);
                System.out.println("producer Produced : "+i + " List size : "+list.size() + " Thread id: "+Thread.currentThread().getName());
                list.notify();
            }

        }
    }
    static class Consumer{

        public void consume() throws InterruptedException {
            synchronized (list) {
                while (list.size() == 0 && !Thread.currentThread().isInterrupted()) {
                    try {
                        list.wait();
                        System.out.println("Consumer waiting"+ " Thread id: "+Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }

                }
                int val = list.removeFirst();
                System.out.println("Consumer Consumed : " + val + " List size : " + list.size()+ " Thread id: "+Thread.currentThread().getName());
                list.notify();
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        final Producer producer=new Producer();
        final Consumer consumer=new Consumer();
        int count=100;
        Thread consumeThread[]=new Thread[5];
        for(int j=0;j<5;j++)
        {
            consumeThread[j]=new Thread(()->{
                for(int i=0;i<count;i++)
                {
                    try {
                        Thread.sleep(3500);
                        consumer.consume();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            consumeThread[j].start();
        }
        Thread prodcerThread[]=new Thread[5];
        for(int j=0;j<5;j++)
        {
            prodcerThread[j]=new Thread(()->{
                for(int i=0;i<count;i++)
                {
                    try {
                        Thread.sleep(7000);
                        try {
                            producer.produce(i);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            prodcerThread[j].start();
        }
        for(int i=0;i<5;i++)
        {
            prodcerThread[i].join();
            consumeThread[i].join();
        }


        /*
        final Thread produceThread=new Thread(()->{
            for(int i=0;i<count;i++)
            {
                try {
                    Thread.sleep(5000);
                    producer.produce(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        produceThread.start();
        produceThread.join();
        consumeThread.join();*/
        System.out.println("Main thread completed");
        System.out.println("size of list="+list.size());
    }
}

/*
1.synchronized(list) means we are obtaining the monitor lock on the object. In Java, every object can be used as a lock.
 In this case, we are using the LinkedList as the lock. Since we are synchronizing access on this list, it would be
 convenient to use it as the lock as well.
2.list.wait() is a method that is inherited from Object. You can only call wait() on a particular object when you are
in the synchronized block locking on the particular object. Otherwise an IllegalMonitorStateException will be thrown.
In this case, I can call wait() on `list` because my synchronized() block is on the `list` as well. Wait() method
tells the thread to give up the monitor lock so that other threads can enter the synchronized block.
3.list.notify() is a method that is inherited from Object as well. You can only call notify() on a particular object
when you are in a synchronized block locking on the particular object. Otherwise an IllegalMonitorStateException will
be thrown. notify() wakes one random thread that is waiting on the monitor lock and let it continue its work.
4.while(....) is to prevent spurious wakeup. Some of the operating systems will cause threads to wake up without being
notified. In this case, if we don't put the condition on while loop, the thread will proceed to poll or push.
And our constraint will be violated. Hence it is always a good idea to guard the condition in a while loop.
 */

