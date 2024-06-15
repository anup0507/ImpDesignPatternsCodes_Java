package com.example.anup.addersubtractorsyncmethod;

public class Count {
    int value=0;

    public synchronized void addCount(int x)
    {
        value+=x;
    }
}
