package com.example.anup.addersubtractorsyncmethod;

public class Adder implements Runnable {
    private Count count;

    public Adder(Count c) {
        this.count=c;

    }

    @Override
    public void run() {
        for(int i=1;i<=1000;i++)
        {
            count.addCount(i);
        }
    }

}
