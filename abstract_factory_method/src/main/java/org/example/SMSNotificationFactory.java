package org.example;

public class SMSNotificationFactory implements NotificationFactory {
    @Override
    public Notification createNotification() {
        return new SMSNotification();
    }

    @Override
    public Template createTemplate() {
        return new SMSTemplate();
    }
}
