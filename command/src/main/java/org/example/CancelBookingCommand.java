package org.example;

public class CancelBookingCommand implements Command {
    private HotelService service;

    public CancelBookingCommand(HotelService service) {
        this.service = service;
    }

    @Override
    public void execute() {
        System.out.println("Executing CancelBookingCommand...");
        service.cancelBooking();
    }
}
