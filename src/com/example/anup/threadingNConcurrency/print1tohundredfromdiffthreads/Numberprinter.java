package com.example.anup.threadingNConcurrency.print1tohundredfromdiffthreads;

public class Numberprinter implements  Runnable{
    int numbertoprint;
    public Numberprinter(int numbertoprint){
        this.numbertoprint = numbertoprint;
    }

    @Override
    public void run() {
        System.out.println("Number : " + numbertoprint + " from thread : " + Thread.currentThread().getName());
    }
}
