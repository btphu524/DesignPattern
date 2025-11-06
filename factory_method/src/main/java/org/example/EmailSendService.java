package org.example;

public class EmailSendService extends SendService {
    @Override
    public Notification getNotification() {
        return new EmailNotification();
    }
}
