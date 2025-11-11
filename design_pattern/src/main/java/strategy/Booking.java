package strategy;

public class Booking {
    private PaymentStrategy paymentStrategy;
    private double totalAmount;

    public Booking(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.paymentStrategy = strategy;
    }

    public void payBill() {
        if (paymentStrategy == null) {
            System.out.println("No payment method selected!");
        } else {
            paymentStrategy.pay(totalAmount);
        }
    }
}
