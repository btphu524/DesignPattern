package org.example;

public class NotificationService {
    public void sendConfirmation(int customerId, String roomType) {
        System.out.println("Sending booking confirmation to customer " + customerId + " for " + roomType);
    }
}
