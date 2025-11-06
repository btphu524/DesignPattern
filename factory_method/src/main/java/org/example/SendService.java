package org.example;

public abstract class SendService {
    public void send() {
        Notification notification = getNotification();
        String noti = notification.notifyUser();
        System.out.println(noti);
    }

    protected abstract Notification getNotification();
}
