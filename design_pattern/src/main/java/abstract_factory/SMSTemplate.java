package abstract_factory;

public class SMSTemplate implements Template {
    @Override
    public String format(String message) {
        return "SMS: " + message;
    }
}
