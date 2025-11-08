import org.example.Logger;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;

public class LoggerTest {

    // 1️⃣ Kiểm tra chỉ có 1 instance duy nhất
    @Test
    void testSingletonInstance() {
        Logger loggerA = Logger.getInstance();
        Logger loggerB = Logger.getInstance();

        System.out.println("✅ Test 1: Singleton instance check");
        assertSame(loggerA, loggerB, "Logger instances should be the same");
    }

    // 2️⃣ Kiểm tra tất cả class khác dùng chung Logger này
    @Test
    void testSharedAcrossClasses() {
        class ServiceA {
            Logger logger = Logger.getInstance();
        }
        class ServiceB {
            Logger logger = Logger.getInstance();
        }

        Logger loggerA = new ServiceA().logger;
        Logger loggerB = new ServiceB().logger;

        System.out.println("✅ Test 2: Shared across classes");
        assertSame(loggerA, loggerB, "Both services should share the same Logger instance");
    }

    // 3️⃣ Chống Reflection: không được tạo thêm instance
    @Test
    void testReflectionProtection() {
        System.out.println("✅ Test 3: Reflection protection");

        Constructor<?>[] constructors = Logger.class.getDeclaredConstructors();
        Constructor<?> constructor = constructors[0];
        constructor.setAccessible(true);

        Exception exception = assertThrows(InvocationTargetException.class, constructor::newInstance);
        assertTrue(exception.getCause() instanceof RuntimeException,
                "Reflection should be blocked by RuntimeException");
    }

    // 4️⃣ Chống Cloning
    @Test
    void testCloneNotSupported() {
        Logger logger = Logger.getInstance();

        System.out.println("✅ Test 4: Cloning protection");
        Exception exception = assertThrows(InvocationTargetException.class, () -> {
            var method = Logger.class.getDeclaredMethod("clone");
            method.setAccessible(true);
            method.invoke(logger);
        });
        assertTrue(exception.getCause() instanceof CloneNotSupportedException,
                "Root cause should be CloneNotSupportedException");
    }

    // 5️⃣ Chống Serialization/Deserialization tạo object mới
    @Test
    void testSerializationProtection() throws IOException, ClassNotFoundException {
        Logger logger1 = Logger.getInstance();

        System.out.println("✅ Test 5: Serialization protection");

        // Serialize object ra file
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("logger.ser"));
        oos.writeObject(logger1);
        oos.close();

        // Deserialize lại
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("logger.ser"));
        Logger logger2 = (Logger) ois.readObject();
        ois.close();

        assertSame(logger1, logger2, "Deserialized object should be the same singleton instance");
        new File("logger.ser").delete(); // cleanup
    }

    // 6️⃣ Test getClass() bảo vệ chống ClassLoader khác nhau
    @Test
    void testClassLoaderProtection() throws Exception {
        var method = Logger.class.getDeclaredMethod("getClass", String.class);
        method.setAccessible(true); // cho phép truy cập private method

        Class<?> cls1 = (Class<?>) method.invoke(null, "org.example.Logger");
        Class<?> cls2 = (Class<?>) method.invoke(null, "org.example.Logger");

        assertSame(cls1, cls2);
        System.out.println("✅ Test 6: ClassLoader protection works (private method tested)");
    }
}
