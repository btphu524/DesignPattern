package factory;

import org.junit.jupiter.api.Test;

public class NotificationFactoryTest {
    @Test
    public void testEmailFactory() {
        NotificationFactory factory = new EmailFactory();
        factory.sendNotification();
    }

    @Test
    public void testSMSFactory() {
        NotificationFactory factory = new SMSFactory();
        factory.sendNotification();
    }

    @Test
    public void testPushFactory() {
        NotificationFactory factory = new PushFactory();
        factory.sendNotification();
    }
}
