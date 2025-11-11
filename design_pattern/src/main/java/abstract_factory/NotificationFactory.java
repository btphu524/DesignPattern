package abstract_factory;

public interface NotificationFactory {
    Notification createNotification();
    Template createTemplate();
}
