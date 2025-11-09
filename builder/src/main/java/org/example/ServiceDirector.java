package org.example;

public class ServiceDirector {
    private final ServiceBuilder builder;

    public ServiceDirector(ServiceBuilder builder) {
        this.builder = builder;
    }

    public Service createSpaService() {
        return builder
                .buildServiceId(1)
                .buildName("Luxury Spa")
                .buildPrice(50.0)
                .buildDescription("Relaxing spa session with essential oils")
                .buildType("Wellness")
                .buildActive(true)
                .build();
    }

    public Service createLaundryService() {
        return builder
                .buildServiceId(2)
                .buildName("Laundry Service")
                .buildPrice(15.0)
                .buildDescription("Clothes washing and ironing")
                .buildType("Cleaning")
                .buildActive(true)
                .build();
    }

    public Service createBreakfastService() {
        return builder
                .buildServiceId(3)
                .buildName("Breakfast Buffet")
                .buildPrice(25.0)
                .buildDescription("Continental breakfast with fresh fruits")
                .buildType("Food")
                .buildActive(true)
                .build();
    }
}
