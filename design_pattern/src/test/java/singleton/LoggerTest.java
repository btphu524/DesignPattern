package singleton;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

public class LoggerTest {
    // 1️⃣ Kiểm tra Singleton instance duy nhất
    @Test
    void testSingletonInstance() {
        Logger logger1 = Logger.INSTANCE;
        Logger logger2 = Logger.INSTANCE;

        System.out.println("✅ Test 1: Singleton instance check");
        assertSame(logger1, logger2, "Logger instances must be the same");
    }

    // 2️⃣ Kiểm tra dùng chung giữa các class khác nhau
    @Test
    void testSharedAcrossClasses() {
        class ServiceA {
            Logger logger = Logger.INSTANCE;
        }
        class ServiceB {
            Logger logger = Logger.INSTANCE;
        }

        Logger loggerA = new ServiceA().logger;
        Logger loggerB = new ServiceB().logger;

        System.out.println("✅ Test 2: Shared across classes");
        assertSame(loggerA, loggerB, "Both services should share the same Logger instance");
    }

    // 3️⃣ Kiểm tra chống Reflection
    @Test
    void testReflectionProtection() {
        System.out.println("✅ Test 3: Reflection protection (Enum auto-protects)");

        // Enum không thể bị tạo qua reflection, nên phải ném exception
        assertThrows(IllegalArgumentException.class, () -> {
            var constructor = Logger.class.getDeclaredConstructors()[0];
            constructor.setAccessible(true);
            constructor.newInstance("INSTANCE", 0);
        });
    }

    // 4️⃣ Kiểm tra chống Cloning (Enum tự bảo vệ)
    @Test
    void testCloneNotSupported() {
        System.out.println("✅ Test 4: Cloning protection (Enum auto-protects)");

        Logger logger = Logger.INSTANCE;
        Exception exception = assertThrows(Exception.class, () -> {
            // Cố tìm method clone() (Enum không có, nên sẽ ném lỗi)
            var method = logger.getClass().getDeclaredMethod("clone");
            method.setAccessible(true);
            method.invoke(logger);
        });

        assertTrue(
                exception instanceof NoSuchMethodException || exception.getCause() instanceof CloneNotSupportedException,
                "Enum should not be clonable"
        );
    }

    // 5️⃣ Kiểm tra Serialization/Deserialization không tạo object mới
    @Test
    void testSerializationProtection() throws IOException, ClassNotFoundException {
        Logger logger1 = Logger.INSTANCE;

        System.out.println("✅ Test 5: Serialization protection (Enum auto-handles)");

        // Serialize ra file
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("logger_enum.ser"));
        oos.writeObject(logger1);
        oos.close();

        // Deserialize lại
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("logger_enum.ser"));
        Logger logger2 = (Logger) ois.readObject();
        ois.close();

        assertSame(logger1, logger2, "Deserialized Enum should still be the same instance");
        new File("logger_enum.ser").delete(); // dọn file
    }

    // 6️⃣ Kiểm tra log thực tế
    @Test
    void testLogOutput() {
        System.out.println("✅ Test 6: Actual log printing");
        Logger logger = Logger.INSTANCE;
        logger.log("System started");
        logger.log("User logged in");
        logger.log("System shutdown");
    }
}
