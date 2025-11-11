package org.example;

public class DirectorHandler implements Handler {
    private Handler nextHandler;

    @Override
    public void setNext(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest(SupportRequest request) {
        System.out.println("\nDirector nhận yêu cầu " + request);

        if (request.getLevel() == 3) {
            System.out.println("Director: Đã xử lý yêu cầu: " + request.getMessage());
        } else {
            System.out.println("❌ Director: Không thể xử lý yêu cầu này!");
        }
    }
}
