package org.example;

public class Service {
    private int serviceId;
    private String name;
    private double price;
    private String description;
    private String type;
    private boolean active;

    public Service(int serviceId, String name, double price, String description, String type, boolean active) {
        this.serviceId = serviceId;
        this.active = active;
        this.type = type;
        this.description = description;
        this.price = price;
        this.name = name;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Service{" +
                "id=" + serviceId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                ", active=" + active +
                '}';
    }
}
