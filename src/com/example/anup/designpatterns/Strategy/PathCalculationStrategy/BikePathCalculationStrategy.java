package com.example.anup.designpatterns.Strategy.PathCalculationStrategy;

public class BikePathCalculationStrategy implements PathCalculationStrategy{
    @Override
    public void calculatePath() {
        System.out.println("Calculating path for bike");
    }
}
