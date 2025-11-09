package org.example;

// Phục vụ tận phòng
public class RoomServiceDecorator extends ServiceDecorator {
    public RoomServiceDecorator(Service service) {
        super(service);
    }

    @Override
    public String getDescription() {
        return service.getDescription() + " + Room Service";
    }

    @Override
    public double getCost() {
        return service.getCost() + 50000;
    }
}
