package org.example;

// Set đặc biệt
public class SpecialSetDecorator extends ServiceDecorator {
    public SpecialSetDecorator(Service service) {
        super(service);
    }

    @Override
    public String getDescription() {
        return service.getDescription() + " + Special Set";
    }

    @Override
    public double getCost() {
        return service.getCost() + 30000;
    }
}
