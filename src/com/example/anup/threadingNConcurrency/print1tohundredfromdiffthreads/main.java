package com.example.anup.threadingNConcurrency.print1tohundredfromdiffthreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class main {
    public static void main(String[] args) {
//        for (int i = 0; i < 100; i++) {
//            Numberprinter numberprinter = new Numberprinter(i);
//            Thread thread = new Thread(numberprinter);
//            thread.start();
//        }
        ExecutorService executorService= Executors.newFixedThreadPool(10);
        for (int i = 0; i < 50000; i++) {
            executorService.execute(new Numberprinter(i));
        }
    }
}
