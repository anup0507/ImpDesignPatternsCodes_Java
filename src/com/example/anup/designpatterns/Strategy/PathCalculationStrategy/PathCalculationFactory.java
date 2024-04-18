package com.example.anup.designpatterns.Strategy.PathCalculationStrategy;

import com.example.anup.designpatterns.Strategy.Mode;

public class PathCalculationFactory {
    public PathCalculationStrategy getPathCalculationStrategy(Mode mode) {
        switch (mode) {
            case CAR:
                return new CarPathCalculationStrategy();
            case BIKE:
                return new BikePathCalculationStrategy();
            case WALK:
                return new WalkPathCalculationStrategy();
            case PUBLIC:
                return new PublicPathCalculationStrategy();
            default:
                return null;
        }
    }
}
