package com.example.anup.addersubtractoratomic;

public class Substractor implements Runnable{
    private Count count;

    public Substractor(Count count) {
        this.count = count;
    }

    @Override
    public void run() {
            for (int i = 1; i <= 1000; ++i) {

                count.addCount(-i);

            }
    }
}
