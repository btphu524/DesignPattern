package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CommandTest {

    private HotelService hotelService;
    private Receptionist receptionist;

    @BeforeEach
    void setUp() {
        hotelService = new HotelService();
        receptionist = new Receptionist();
    }

    @Test
    void testBookRoomCommand() {
        System.out.println("==============================");
        System.out.println("HotelService: Booking room...");
        Command bookRoom = new BookRoomCommand(hotelService);
        receptionist.takeCommand(bookRoom);
        receptionist.processCommands(); // In ra console
    }

    @Test
    void testCancelBookingCommand() {
        System.out.println("==============================");
        System.out.println("HotelService: Cancel booking room...");
        Command cancelBooking = new CancelBookingCommand(hotelService);
        receptionist.takeCommand(cancelBooking);
        receptionist.processCommands(); // In ra console
    }

    @Test
    void testRequestServiceCommand() {
        System.out.println("==============================");
        System.out.println("HotelService: Requesting room service...");
        Command requestService = new RequestServiceCommand(hotelService);
        receptionist.takeCommand(requestService);
        receptionist.processCommands(); // In ra console
    }

    @Test
    void testMultipleCommandsOrder() {
        System.out.println("==============================");
        System.out.println("HotelService: Multiple commands order...");
        receptionist.takeCommand(new BookRoomCommand(hotelService));
        receptionist.takeCommand(new RequestServiceCommand(hotelService));
        receptionist.takeCommand(new CancelBookingCommand(hotelService));
        receptionist.processCommands(); // In ra console theo thứ tự
    }
}
