package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class BookingFacadeTest {
    @Test
    void testBookRoom() {
        BookingFacade bookingFacade = new BookingFacade();
        System.out.println("\n--- Running JUnit Test for Facade Pattern ---");
        assertDoesNotThrow(() -> bookingFacade.bookRoom(202, "Luxury"));
    }
}
