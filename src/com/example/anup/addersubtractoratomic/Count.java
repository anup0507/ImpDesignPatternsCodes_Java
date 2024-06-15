package com.example.anup.addersubtractoratomic;

import java.util.concurrent.atomic.AtomicInteger;

public class Count {
   // int value=0;
    AtomicInteger value=new AtomicInteger(0);
    public void addCount(int x)
    {
        this.value.addAndGet(x);
        //value+=x;
    }
}
