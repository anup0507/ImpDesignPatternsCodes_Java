package com.example.anup.designpatterns.Observer;

import java.util.ArrayList;
import java.util.List;

public class Flipkart {
    List<OrderPlacedSubscriber> subscribers = new ArrayList<>();
    public void addSubscriber(OrderPlacedSubscriber subscriber) {
        subscribers.add(subscriber);
    }
    public void removeSubscriber(OrderPlacedSubscriber subscriber) {
        subscribers.remove(subscriber);
    }
    public void OrderPlaced(Order orderDetails) {
        for (OrderPlacedSubscriber subscriber : subscribers) {
            subscriber.onOrderPlaced(orderDetails);
        }
    }

}
