package org.example;

public class Accounting implements Observer {
    @Override
    public void update(String roomStatus) {
        System.out.println("Accounting updated: Room is " + roomStatus);
    }
}
