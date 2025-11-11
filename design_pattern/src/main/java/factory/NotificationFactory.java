package factory;

public abstract class NotificationFactory {
    public void sendNotification() {
        Notification noti = createNotification();
        noti.send();
    }

    protected abstract Notification createNotification();
}
