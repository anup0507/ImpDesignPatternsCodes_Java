package com.example.anup.threadingNConcurrency.printhelloWorld;

public class printHelloWorld implements Runnable{
    @Override
    public void run() {
        System.out.println("Hello World from thread : " + Thread.currentThread().getName());
    }
}
