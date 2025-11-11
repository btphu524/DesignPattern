package org.example;

public class SupportRequest {
    private int level;
    private String message;

    public SupportRequest(int level, String message) {
        this.level = level;
        this.message = message;
    }

    public int getLevel() {
        return level;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "[Cấp độ: " + level + ", Nội dung: " + message + "]";
    }
}
