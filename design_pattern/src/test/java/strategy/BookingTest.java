package strategy;

import org.junit.jupiter.api.Test;

public class BookingTest {
    @Test
    void testCreditCardPayment() {
        Booking booking = new Booking(500);
        booking.setPaymentStrategy(new CreditCardPayment("1234-5678-9012-3456"));
        booking.payBill();
    }

    @Test
    void testPayPalPayment() {
        Booking booking = new Booking(300);
        booking.setPaymentStrategy(new PayPalPayment("user@example.com"));
        booking.payBill();
    }

    @Test
    void testCashPayment() {
        Booking booking = new Booking(200);
        booking.setPaymentStrategy(new CashPayment());
        booking.payBill();
    }
}
