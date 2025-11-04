package org.example;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.time.LocalDateTime;

public class Logger implements Serializable, Cloneable {

    // Mã phiên bản cho Serialization, giúp đảm bảo tương thích khi deserialize
    private static final long serialVersionUID = 1L;

    // Biến static lưu instance duy nhất
    // Khởi tạo eager (ngay khi load class) để đảm bảo thread-safe đơn giản
    private static Logger instance = new Logger();

    /**
     * Constructor private để ngăn tạo mới từ bên ngoài.
     * Nếu ai đó cố gắng gọi qua reflection thì ném lỗi luôn.
     */
    private Logger() {
        if (instance != null) {
            throw new RuntimeException("Already created, use getInstance() method instead!");
        }
        System.out.println("Logger initialized.");
    }

    /**
     * Trả về instance duy nhất của Logger.
     * Có thêm double-checked locking để an toàn khi đa luồng.
     */
    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    /**
     * Ghi log ra console (mô phỏng hành động ghi log)
     */
    public void log(String message) {
        System.out.println(LocalDateTime.now() + " - [LOG]: " + message);
    }

    /**
     * Chống clone: không cho phép tạo bản sao của Singleton
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Logger cannot be cloned");
    }

    /**
     * Chống phá vỡ Singleton khi deserialize object từ file
     * Khi đọc từ stream, Java sẽ gọi readResolve(), trả về instance sẵn có
     */
    private Object readResolve() throws ObjectStreamException {
        return instance;
    }

    /**
     * Đảm bảo khi serialize, cũng trả về cùng instance
     */
    private Object writeReplace() throws ObjectStreamException {
        return instance;
    }

    /**
     * Chống tạo nhiều instance nếu class bị load bởi các classloader khác nhau.
     * Giúp giữ cho Singleton thực sự chỉ có 1 đối tượng trong toàn JVM.
     */
    private static Class<?> getClass(String classname) throws ClassNotFoundException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        if (classLoader == null)
            classLoader = Logger.class.getClassLoader();
        return (classLoader.loadClass(classname));
    }
}
