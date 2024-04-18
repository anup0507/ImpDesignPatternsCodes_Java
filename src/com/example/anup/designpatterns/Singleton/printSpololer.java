package com.example.anup.designpatterns.Singleton;

import java.util.LinkedList;
import java.util.Queue;

public class printSpololer {
    private static printSpololer instance;
    private final Queue<String> printQueue;
    private printSpololer() {
        printQueue=new LinkedList<>();
    }

    public static printSpololer getInstance() {
        if (instance == null) {
            instance = new printSpololer();
        }
        return instance;
    }

    public void addToQueue(String message) {
        printQueue.add(message);
    }
    public String processnextJob() {
        if(printQueue.isEmpty()) {
            return "Queue is empty";
        }
        return printQueue.poll();
    }
    public void printSpooler(String message) {
        System.out.println("Printing: " + message);
    }
}
