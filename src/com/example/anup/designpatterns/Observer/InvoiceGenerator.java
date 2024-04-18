package com.example.anup.designpatterns.Observer;

public class InvoiceGenerator implements OrderPlacedSubscriber{
    public InvoiceGenerator(Flipkart flipkart) {
        flipkart.addSubscriber(this);
    }
    @Override
    public void onOrderPlaced(Order orderDetails) {
        GenerateInvoice(orderDetails);
    }
    public void GenerateInvoice(Order orderDetails) {
        System.out.println("Invoice generated with order details: " + orderDetails.orderId + " for product: " + orderDetails.productId);
    }
}
