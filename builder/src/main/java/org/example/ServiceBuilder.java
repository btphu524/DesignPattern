package org.example;

public interface ServiceBuilder {
    ServiceBuilder buildServiceId(int id);
    ServiceBuilder buildName(String name);
    ServiceBuilder buildPrice(double price);
    ServiceBuilder buildDescription(String description);
    ServiceBuilder buildType(String type);
    ServiceBuilder buildActive(boolean active);
    Service build();
}
