package observer;

public class Reception implements Observer {
    @Override
    public void update(String roomStatus) {
        System.out.println("Reception updated room status: " + roomStatus);
    }
}
