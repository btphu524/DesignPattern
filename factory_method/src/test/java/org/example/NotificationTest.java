package org.example;

import org.junit.jupiter.api.Test;

public class NotificationTest {
    @Test
    public void testNotification() {
        SendService service = new EmailSendService();
        service.send();

        service = new PushSendService();
        service.send();

        service = new SMSSendService();
        service.send();
    }
}
