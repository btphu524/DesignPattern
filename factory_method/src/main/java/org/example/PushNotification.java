package org.example;

public class PushNotification implements Notification {
    @Override
    public String notifyUser() {
        System.out.println("Sending an Push Notification...");
        return "Push Notification";
    }
}
