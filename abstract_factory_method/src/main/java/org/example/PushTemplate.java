package org.example;

public class PushTemplate implements Template {
    @Override
    public String format(String message) {
        return "Push: " + message;
    }
}
