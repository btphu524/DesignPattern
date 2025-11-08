package org.example;

public class SMSNotification implements Notification {
    @Override
    public void send() {
        System.out.println("Sending SMS Notification...");
    }
}
