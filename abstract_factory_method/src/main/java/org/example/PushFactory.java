package org.example;

public class PushFactory implements NotificationFactory {
    @Override
    public Notification createNotification() {
        return new PushNotification();
    }

    @Override
    public Template createTemplate() {
        return new PushTemplate();
    }
}
