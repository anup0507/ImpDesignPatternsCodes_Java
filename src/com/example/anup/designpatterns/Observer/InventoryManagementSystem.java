package com.example.anup.designpatterns.Observer;

public class InventoryManagementSystem implements OrderPlacedSubscriber{
    public InventoryManagementSystem(Flipkart flipkart) {
        flipkart.addSubscriber(this);
    }
    @Override
    public void onOrderPlaced(Order orderDetails) {
        System.out.println("Inventory updated with order details: " + orderDetails.orderId + " for product: " + orderDetails.productId);
    }
}
