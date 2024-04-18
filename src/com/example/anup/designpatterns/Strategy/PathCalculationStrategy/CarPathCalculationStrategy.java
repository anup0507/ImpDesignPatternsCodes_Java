package com.example.anup.designpatterns.Strategy.PathCalculationStrategy;

public class CarPathCalculationStrategy  implements PathCalculationStrategy{
    @Override
    public void calculatePath() {
        System.out.println("Calculating path for car");
    }
}
