package singleton;

import java.time.LocalDateTime;

public enum Logger {
    INSTANCE;

    Logger() {
        System.out.println("Logger initialized...");
    }

    public void log(String message) {
        String timeStampedMsg = "[" + LocalDateTime.now() + "] " + message;
        System.out.println(timeStampedMsg);
    }
}