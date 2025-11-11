package abstract_factory;

public class NotificationService {
    public final Notification notification;
    public final Template template;

    public NotificationService(NotificationFactory factory) {
        this.notification = factory.createNotification();
        this.template = factory.createTemplate();
    }

    public void process(String message) {
        String formatted = template.format(message);
        System.out.println("Formatted message: " + formatted);
        notification.send();
    }
}
