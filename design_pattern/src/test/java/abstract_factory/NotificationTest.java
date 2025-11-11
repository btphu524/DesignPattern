package abstract_factory;

import org.junit.jupiter.api.Test;

public class NotificationTest {

    @Test
    public void testEmailNotification() {
        System.out.println("======================================");
        NotificationFactory factory = new EmailFactory();
        NotificationService service = new NotificationService(factory);
        service.process("Hello Email");
    }

    @Test
    public void testSMSNotification() {
        System.out.println("======================================");
        NotificationFactory factory = new SMSFactory();
        NotificationService service = new NotificationService(factory);
        service.process("Hello SMS");
    }

    @Test
    public void testPushNotification() {
        System.out.println("======================================");
        NotificationFactory factory = new PushFactory();
        NotificationService service = new NotificationService(factory);
        service.process("Hello Push");
    }
}
