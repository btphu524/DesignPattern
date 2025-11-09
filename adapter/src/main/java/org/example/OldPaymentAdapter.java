package org.example;

public class OldPaymentAdapter implements PaymentProcessor {
    private OldPaymentSystem oldPaymentSystem;

    public OldPaymentAdapter(OldPaymentSystem oldPaymentSystem) {
        this.oldPaymentSystem = oldPaymentSystem;
    }

    @Override
    public void pay(String customerName, double amount) {
        // Chuyển đổi logic: từ tên khách → mã thanh toán
        String paymentCode = "PAY-" + customerName.toUpperCase().replace(" ", "_");
        System.out.println("Adapter converting request for customer: " + customerName);
        oldPaymentSystem.makePayment(paymentCode, amount);
    }
}
