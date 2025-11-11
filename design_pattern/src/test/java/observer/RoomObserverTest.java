package observer;

import org.junit.jupiter.api.Test;

public class RoomObserverTest {
    @Test
    void testObserverPattern() {
        Room room = new Room();

        Observer reception = new Reception();
        Observer housekeeping = new Housekeeping();
        Observer accounting = new Accounting();

        // Đăng ký các bộ phận nhận thông báo
        room.attach(reception);
        room.attach(housekeeping);
        room.attach(accounting);

        System.out.println("\n--- Thay đổi trạng thái phòng sang 'Đã đặt' ---");
        room.setStatus("Đã đặt");

        System.out.println("\n--- Thay đổi trạng thái phòng sang 'Đang sử dụng' ---");
        room.setStatus("Đang sử dụng");

        // Hủy đăng ký 1 observer
        room.detach(accounting);
        System.out.println("\n--- Thay đổi trạng thái phòng sang 'Trống' ---");
        room.setStatus("Trống");
    }
}
