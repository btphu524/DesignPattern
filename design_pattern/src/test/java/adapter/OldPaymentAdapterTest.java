package adapter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class OldPaymentAdapterTest {
    @Test
    void testAdapterConvertsAndCallsOldSystem() {
        OldPaymentSystem oldSystem = new OldPaymentSystem();
        PaymentProcessor adapter = new OldPaymentAdapter(oldSystem);

        assertDoesNotThrow(() -> adapter.pay("John Doe", 250.0));
    }
}
