package org.example;

public class ServiceProxy implements Service {
    private RealService realService;
    private int serviceId;
    private String name;

    public ServiceProxy(int serviceId, String name) {
        this.serviceId = serviceId;
        this.name = name;
    }

    @Override
    public String getInfor() {
        if (realService == null) {
            System.out.println("Proxy: Creating RealService instance (Lazy Loading)...");
            realService = new RealService(serviceId, name);
        } else {
            System.out.println("Proxy: Using cached RealService instance.");
        }
        return realService.getInfor();
    }
}
