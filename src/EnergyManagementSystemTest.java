import org.junit.jupiter.api.Test;
import java.util.Map;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.jupiter.api.Assertions.*;

public class EnergyManagementSystemTest {

    @Test
    public void testAllocateEnergySufficient() {
        EnergyManagementSystem energySystem = new EnergyManagementSystem();
        assertTrue(energySystem.allocateEnergy(EnergySource.SOLAR, 50));
        // Test if the allocation is successful when sufficient energy is available
    }

    @Test
    public void testAllocateEnergyInsufficient() {
        EnergyManagementSystem energySystem = new EnergyManagementSystem();
        assertFalse(energySystem.allocateEnergy(EnergySource.WIND, 150));
        assertFalse(energySystem.allocateEnergy(EnergySource.SOLAR, -10));
        // Test if the allocation fails when insufficient energy is available or invalid amount
    }

    @Test
    public void testOptimizeEnergyUsage() {
        // Not directly testable without changing the system state
        // Consider testing the impact of optimization on energy allocation instead
    }

    @Test
    public void testReportEnergyStatus() {
        EnergyManagementSystem energySystem = new EnergyManagementSystem();

        // Redirect logging output to capture log messages
        Logger logger = Logger.getLogger(EnergyManagementSystem.class.getName());
        Handler handler = new TestHandler();
        logger.addHandler(handler);

        energySystem.reportEnergyStatus();

        // Verify if log messages contain expected information about energy status
        assertTrue(((TestHandler) handler).getLogMessages().contains("Energy Status:"));
        // Include more specific assertions based on expected log messages
    }

    @Test
    public void testConcurrentAllocation() throws InterruptedException {
        final EnergyManagementSystem energySystem = new EnergyManagementSystem();

        Thread thread1 = new Thread(() -> {
            assertTrue(energySystem.allocateEnergy(EnergySource.WIND, 50));
        });
        Thread thread2 = new Thread(() -> {
            assertFalse(energySystem.allocateEnergy(EnergySource.WIND, 150));
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        // Both threads can't allocate energy simultaneously if it's insufficient
        // Thread 1 should succeed, Thread 2 should fail
    }


    // Inner class to capture log messages for testing purposes
    private static class TestHandler extends Handler {
        private StringBuilder logMessages = new StringBuilder();

        public void publish(java.util.logging.LogRecord record) {
            logMessages.append(record.getMessage()).append("\n");
        }

        public void flush() {
        }

        public void close() throws SecurityException {
        }

        public String getLogMessages() {
            return logMessages.toString();
        }
    }
}
