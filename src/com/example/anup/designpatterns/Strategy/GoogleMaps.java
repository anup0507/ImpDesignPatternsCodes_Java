package com.example.anup.designpatterns.Strategy;

import com.example.anup.designpatterns.Strategy.PathCalculationStrategy.PathCalculationFactory;

public class GoogleMaps {
    PathCalculationFactory pathCalculationFactory;
    public GoogleMaps(){
        pathCalculationFactory = new PathCalculationFactory();
    }
    public void FindPath(Mode mode){
        pathCalculationFactory = new PathCalculationFactory();
        pathCalculationFactory.getPathCalculationStrategy(mode).calculatePath();
    }

}
