package org.example;

public class Housekeeping implements Observer {
    @Override
    public void update(String roomStatus) {
        System.out.println("Housekeeping notified: Room is now " + roomStatus);
    }
}
