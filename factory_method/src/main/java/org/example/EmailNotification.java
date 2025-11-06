package org.example;

public class EmailNotification implements Notification {
    @Override
    public String notifyUser() {
        System.out.println("Sending an Email Notification...");
        return "Email Notification";
    }
}
