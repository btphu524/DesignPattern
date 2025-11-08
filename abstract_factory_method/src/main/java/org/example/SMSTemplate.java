package org.example;

public class SMSTemplate implements Template {
    @Override
    public String format(String message) {
        return "SMS: " + message;
    }
}
