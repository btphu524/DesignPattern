package facade;

public class BookingFacade {
    private RoomService roomService;
    private BillingService billingService;
    private PaymentService paymentService;
    private NotificationService notificationService;

    public BookingFacade() {
        this.roomService = new RoomService();
        this.billingService = new BillingService();
        this.paymentService = new PaymentService();
        this.notificationService = new NotificationService();
    }

    public void bookRoom(int customerId, String roomType) {
        System.out.println("=== Booking Process Started ===");
        if (roomService.checkRoom(roomType)) {
            String bill = billingService.createBill(customerId, roomType);
            if (paymentService.processPayment(bill)) {
                notificationService.sendConfirmation(customerId, roomType);
                System.out.println("Booking completed successfully!");
            } else {
                System.out.println("Payment failed!");
            }
        } else {
            System.out.println("No available room for type: " + roomType);
        }
        System.out.println("=== Booking Process Ended ===");
    }
}
