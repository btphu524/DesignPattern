package org.example;

public class RequestServiceCommand implements Command {
    private HotelService service;

    public RequestServiceCommand(HotelService service) {
        this.service = service;
    }

    @Override
    public void execute() {
        System.out.println("Executing RequestServiceCommand...");
        service.requestService();
    }
}
