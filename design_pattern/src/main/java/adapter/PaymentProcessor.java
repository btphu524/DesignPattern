package adapter;

public interface PaymentProcessor {
    void pay(String customerName, double amount);
}
