package org.example;

import org.junit.jupiter.api.Test;

public class ChainOfResponsibilityTest {
    @Test
    public void testChain() {
        // Tạo các handler
        Handler reception = new ReceptionHandler();
        Handler manager = new ManagerHandler();
        Handler director = new DirectorHandler();

        // Tạo chuỗi xử lý
        reception.setNext(manager);
        manager.setNext(director);

        // Gửi các yêu cầu khác nhau
        SupportRequest req1 = new SupportRequest(1, "Khách hỏi giờ check-in");
        SupportRequest req2 = new SupportRequest(2, "Khách khiếu nại về phòng không sạch");
        SupportRequest req3 = new SupportRequest(3, "Khách yêu cầu bồi thường thiệt hại lớn");
        SupportRequest req4 = new SupportRequest(4, "Yêu cầu vượt cấp không ai xử lý được");

        reception.handleRequest(req1);
        reception.handleRequest(req2);
        reception.handleRequest(req3);
        reception.handleRequest(req4);
    }

}
