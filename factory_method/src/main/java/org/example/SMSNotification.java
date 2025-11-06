package org.example;

public class SMSNotification implements Notification {
    @Override
    public String notifyUser() {
        System.out.println("Sending an SMS Notification...");
        return "SMS Notification";
    }
}
