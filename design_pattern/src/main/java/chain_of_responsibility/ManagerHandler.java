package chain_of_responsibility;

public class ManagerHandler implements Handler {
    private Handler nextHandler;

    @Override
    public void setNext(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest(SupportRequest request) {
        System.out.println("\nManager nhận yêu cầu " + request);

        if (request.getLevel() == 2) {
            System.out.println("Manager: Đã xử lý yêu cầu: " + request.getMessage());
        } else {
            System.out.println("Manager: Không đủ thẩm quyền, chuyển lên cấp cao hơn...");
            if (nextHandler != null)
                nextHandler.handleRequest(request);
            else
                System.out.println("❌ Không có cấp cao hơn để xử lý!");
        }
    }
}
