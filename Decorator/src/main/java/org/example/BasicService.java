package org.example;

public class BasicService implements Service {
    private final String name;
    private final double price;

    public BasicService(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getDescription() {
        return name;
    }

    @Override
    public double getCost() {
        return price;
    }
}
