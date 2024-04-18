package com.example.anup.designpatterns.Observer;

public class SMSService implements  OrderPlacedSubscriber{
    public SMSService(Flipkart flipkart) {
        flipkart.addSubscriber(this);
    }
    @Override
    public void onOrderPlaced(Order orderDetails) {
        System.out.println("SMS sent to customer with order details: " + orderDetails.orderId + " for product: " + orderDetails.productId);
    }
}
