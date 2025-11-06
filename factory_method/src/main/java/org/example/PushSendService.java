package org.example;

public class PushSendService extends SendService {
    @Override
    public Notification getNotification() {
        return new PushNotification();
    }
}
