package com.hotel.services;

public class PaymentService {
    public boolean processPayment(double amount) {
        // Implement payment processing logic
        System.out.println("Payment of $" + amount + " has been processed successfully.");
        return true; // Assuming payment is always successful
    }
}