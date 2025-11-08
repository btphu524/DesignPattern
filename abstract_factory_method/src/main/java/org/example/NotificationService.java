package org.example;

public class NotificationService {
    public final Notification notification;
    public final Template template;

    public NotificationService(NotificationFactory factory) {
        this.notification = factory.createNotification();
        this.template = factory.createTemplate();
    }

    public void send() {
        System.out.println(template.getTemplate());
        notification.notifyUser();
    }
}
