package org.example;

public class RealService implements Service {
    private int serviceId;
    private String name;

    public RealService(int serviceId, String name) {
        this.serviceId = serviceId;
        this.name = name;
        System.out.println("RealService: Loading data from DB...");
    }

    @Override
    public String getInfor() {
        return "Service ID: " + serviceId + ", Name: " + name;
    }
}
