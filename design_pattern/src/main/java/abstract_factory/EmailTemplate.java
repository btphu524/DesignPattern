package abstract_factory;

public class EmailTemplate implements Template {
    @Override
    public String format(String message) {
        return "Email: " +  message;
    }
}
