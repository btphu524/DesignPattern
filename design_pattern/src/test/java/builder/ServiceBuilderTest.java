package builder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ServiceBuilderTest {
    @Test
    public void testBuildCustomService() {
        System.out.println("==============================");
        Service service = new ConcreteServiceBuilder()
                .buildServiceId(100)
                .buildName("Room Cleaning")
                .buildPrice(20.5)
                .buildDescription("Daily cleaning service")
                .buildType("Housekeeping")
                .buildActive(true)
                .build();

        assertEquals("Room Cleaning", service.getName());
        assertTrue(service.isActive());
        System.out.println(service);
    }

    @Test
    public void testBuildByDirector() {
        System.out.println("==============================");
        ServiceBuilder builder = new ConcreteServiceBuilder();
        ServiceDirector director = new ServiceDirector(builder);

        Service spa = director.createSpaService();
        assertEquals("Luxury Spa", spa.getName());
        assertEquals("Wellness", spa.getType());
        System.out.println(spa);

        Service laundry = director.createLaundryService();
        assertEquals("Laundry Service", laundry.getName());
        assertEquals("Cleaning", laundry.getType());
        System.out.println(laundry);

        Service breakfast = director.createBreakfastService();
        assertEquals("Breakfast Buffet", breakfast.getName());
        assertEquals("Food", breakfast.getType());
        System.out.println(breakfast);

    }
}
