package org.example;

public class SMSTemplate implements Template {
    @Override
    public String getTemplate() {
        return "SMS Template: Hello, your code is 123456";
    }
}
