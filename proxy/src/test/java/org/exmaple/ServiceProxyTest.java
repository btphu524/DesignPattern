package org.exmaple;

import org.example.Service;
import org.example.ServiceProxy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServiceProxyTest {
    @Test
    void testProxyLazyLoading() {
        Service service = new ServiceProxy(101, "Room Cleaning");
        // Chưa load RealService
        String info = service.getInfor();
        assertEquals("Service ID: 101, Name: Room Cleaning", info);

        // Gọi lần nữa, vẫn trả về đúng nhưng không load lại RealService
        String info2 = service.getInfor();
        assertEquals(info, info2);
    }
}
