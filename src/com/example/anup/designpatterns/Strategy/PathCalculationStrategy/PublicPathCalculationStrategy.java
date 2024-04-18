package com.example.anup.designpatterns.Strategy.PathCalculationStrategy;

public class PublicPathCalculationStrategy implements PathCalculationStrategy{
    @Override
    public void calculatePath() {
        System.out.println("Calculating path for public transport");
    }

}
