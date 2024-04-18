package com.example.anup.threadingNConcurrency.printhelloWorld;

public class Client {
    public static void main(String[] args) {
        System.out.println("Hello World from thread : " + Thread.currentThread().getName());
        Thread thread1 = new Thread(new printHelloWorld());

        thread1.start();
        System.out.println("Hello World from thread : " + Thread.currentThread().getName());
    }
}
