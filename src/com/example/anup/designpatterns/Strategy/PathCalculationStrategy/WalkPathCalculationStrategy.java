package com.example.anup.designpatterns.Strategy.PathCalculationStrategy;

public class WalkPathCalculationStrategy implements PathCalculationStrategy{
    @Override
    public void calculatePath() {
        System.out.println("Calculating path for walk");
    }
}
