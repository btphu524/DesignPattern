package org.example;

public class ConcreteServiceBuilder implements ServiceBuilder {
    private int serviceId;
    private String name;
    private double price;
    private String description;
    private String type;
    private boolean active;

    @Override
    public ServiceBuilder buildServiceId(int id) {
        this.serviceId = id;
        return this;
    }

    @Override
    public ServiceBuilder buildName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public ServiceBuilder buildPrice(double price) {
        this.price = price;
        return this;
    }

    @Override
    public ServiceBuilder buildDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public ServiceBuilder buildType(String type) {
        this.type = type;
        return this;
    }

    @Override
    public ServiceBuilder buildActive(boolean active) {
        this.active = active;
        return this;
    }

    @Override
    public Service build() {
        return new Service(serviceId, name, price, description, type, active);
    }
}
