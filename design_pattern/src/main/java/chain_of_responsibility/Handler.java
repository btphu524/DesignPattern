package chain_of_responsibility;

public interface Handler {
    void setNext(Handler nextHandler);
    void handleRequest(SupportRequest request);
}
