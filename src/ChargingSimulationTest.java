import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ChargingSimulationTest {

    @Test
    public void testGetRandomEnergySource() {
        ChargingSimulation chargingSimulation = new ChargingSimulation();
        EnergySource energySource = chargingSimulation.getRandomEnergySource();

        assertNotNull(energySource);
        assertTrue(energySource instanceof EnergySource);
    }

}
