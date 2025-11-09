package org.example;

public class BillingService {
    public String createBill(int customerId, String roomType) {
        String bill = "Bill for customer " + customerId + " - Room: " + roomType;
        System.out.println("Creating bill: " + bill);
        return bill;
    }
}
