package org.example;

public class BookRoomCommand implements Command {
    private HotelService service;

    public BookRoomCommand(HotelService service) {
        this.service = service;
    }

    @Override
    public void execute() {
        System.out.println("Executing BookRoomCommand...");
        service.bookRoom();
    }
}
