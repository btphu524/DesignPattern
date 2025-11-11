package org.example;

public interface Handler {
    void setNext(Handler nextHandler);
    void handleRequest(SupportRequest request);
}
