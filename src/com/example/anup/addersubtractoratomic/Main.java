package com.example.anup.addersubtractoratomic;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Count c = new Count();

        Thread t1 = new Thread(new Adder(c));
        Thread t2 = new Thread(new Substractor(c));

        t1.start();
        t2.start();

        t1.join(); // waits for the thread to complete - code will not go to next line till t1 completes
        t2.join();

        System.out.println(c.value);
    }
}
