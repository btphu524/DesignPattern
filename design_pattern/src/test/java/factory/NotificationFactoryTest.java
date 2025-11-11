package factory;

import org.junit.jupiter.api.Test;

public class NotificationFactoryTest {
    @Test
    public void testEmailFactory() {
        NotificationFactory factory = new EmailFactory();
        factory.sendNotification(); // Sending Email Notification...
    }

    @Test
    public void testSMSFactory() {
        NotificationFactory factory = new SMSFactory();
        factory.sendNotification(); // Sending SMS Notification...
    }

    @Test
    public void testPushFactory() {
        NotificationFactory factory = new PushFactory();
        factory.sendNotification(); // Sending Push Notification...
    }
}
