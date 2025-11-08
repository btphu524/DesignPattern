package org.example;

import org.junit.jupiter.api.Test;

public class NotificationTest {

    @Test
    public void testEmailNotification() {
        System.out.println("======================================");
        NotificationFactory factory = new EmailNotificationFactory();
        NotificationService service = new NotificationService(factory);
        service.send();
    }

    @Test
    public void testSMSNotification() {
        System.out.println("======================================");
        NotificationFactory factory = new SMSNotificationFactory();
        NotificationService service = new NotificationService(factory);
        service.send();
    }

    @Test
    public void testPushNotification() {
        System.out.println("======================================");
        NotificationFactory factory = new PushNotificationFactory();
        NotificationService service = new NotificationService(factory);
        service.send();
    }

    @Test
    public void testMultipleNotifications() {
        System.out.println("======================================");
        NotificationFactory factory;

        // Email
        factory = new EmailNotificationFactory();
        new NotificationService(factory).send();

        // SMS
        factory = new SMSNotificationFactory();
        new NotificationService(factory).send();

        // Push
        factory = new PushNotificationFactory();
        new NotificationService(factory).send();
    }
}
