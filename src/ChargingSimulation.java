import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChargingSimulation {
	 public static void main(String[] args) {
	        ChargingStation station1 = new ChargingStation("Station A", 3);
	        ChargingStation station2 = new ChargingStation("Station B", 2);

	        ExecutorService executorService = Executors.newFixedThreadPool(5); // Simulating 5 reserved batteries
	        int numBatteries = 5;

	        for (int i = 0; i < numBatteries; i++) {
	            ReservedBattery battery = new ReservedBattery(i + 1);
	            EnergySource energySource = getRandomEnergySource(); // Get a random energy source
	            ChargingStation station = (i % 2 == 0) ? station1 : station2; // Alternate between stations
	            executorService.submit(() -> station.chargeBattery(battery, energySource));
	        }

	        executorService.shutdown();
	    }

	    private static EnergySource getRandomEnergySource() {
	        EnergySource[] sources = EnergySource.values();
	        int index = (int) (Math.random() * sources.length);
	        return sources[index];
	    }
}
