package com.example.anup.designpatterns.Observer;

public class EmailService implements OrderPlacedSubscriber {
    public EmailService(Flipkart flipkart) {
        flipkart.addSubscriber(this);
    }

    @Override
    public void onOrderPlaced(Order orderDetails) {
        SendEmail(orderDetails);
    }
    public void SendEmail(Order orderDetails) {
        System.out.println("Email sent to customer with order details: " + orderDetails.orderId + " for product: " + orderDetails.productId);
    }
}
