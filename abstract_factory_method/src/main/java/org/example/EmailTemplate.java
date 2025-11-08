package org.example;

public class EmailTemplate implements Template {
    @Override
    public String getTemplate() {
        return "Email Template: Dear customer,...";
    }
}
