package facade;

public class PaymentService {
    public boolean processPayment(String bill) {
        System.out.println("Processing payment for: " + bill);
        return true; // Thanh toán thành công
    }
}
