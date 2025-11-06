package org.example;

public class SMSSendService extends SendService {
    @Override
    public Notification getNotification() {
        return new SMSNotification();
    }
}
