package decorator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServiceDecoratorTest {
    @Test
    void testBasicService() {
        Service breakfast = new BasicService("Breakfast", 100_000);

        System.out.println("=== Basic Service ===");
        System.out.println("Description: " + breakfast.getDescription());
        System.out.println("Cost: " + breakfast.getCost());

        assertEquals("Breakfast", breakfast.getDescription());
        assertEquals(100_000, breakfast.getCost());
    }

    @Test
    void testDecoratedService() {
        Service breakfast = new BasicService("Breakfast", 100_000);
        breakfast = new RoomServiceDecorator(breakfast);
        breakfast = new SpecialSetDecorator(breakfast);

        System.out.println("\n=== Decorated Service ===");
        System.out.println("Description: " + breakfast.getDescription());
        System.out.println("Total Cost: " + breakfast.getCost());

        assertEquals("Breakfast + Room Service + Special Set", breakfast.getDescription());
        assertEquals(180_000, breakfast.getCost());
    }
}
