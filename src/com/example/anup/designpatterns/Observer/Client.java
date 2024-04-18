package com.example.anup.designpatterns.Observer;

public class Client {
    public static void main(String[] args) {
        Flipkart flipkart = new Flipkart();
        OrderPlacedSubscriber subscriber1 = new EmailService(flipkart);
        OrderPlacedSubscriber subscriber2 = new SMSService(flipkart);
        OrderPlacedSubscriber subscriber3 = new InventoryManagementSystem(flipkart);
        OrderPlacedSubscriber subscriber4 = new InvoiceGenerator(flipkart);


        Order order = new Order();
        order.setOrderId(1L);
        order.setProductId(100L);
        order.setCustomerEmail("xyz@gmail.com");
        order.setCustomerPhoneNumber("1234567890");
        flipkart.OrderPlaced(order);
    }
}
