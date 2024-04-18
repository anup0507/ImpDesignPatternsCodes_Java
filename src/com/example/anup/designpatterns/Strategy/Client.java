package com.example.anup.designpatterns.Strategy;

public class Client {
    public static void main(String[] args) {
        GoogleMaps googleMaps = new GoogleMaps();
        googleMaps.FindPath(Mode.BIKE);
        googleMaps.FindPath(Mode.CAR);
        googleMaps.FindPath(Mode.WALK);
        googleMaps.FindPath(Mode.PUBLIC);
    }
}
