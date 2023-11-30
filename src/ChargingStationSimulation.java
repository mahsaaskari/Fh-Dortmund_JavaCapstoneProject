import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ChargingStationSimulation {
    private static final Logger LOGGER = Logger.getLogger(ChargingStationSimulation.class.getName());

    public static void main(String[] args) {
        logSystemEvent("Starting the charging station simulation.");

        List<ChargingStation> chargingStations = new ArrayList<>();
        List<Car> cars = new ArrayList<>();

    
     // Initialize charging stations
        chargingStations.add(new ChargingStation(1, 3));
        chargingStations.add(new ChargingStation(2, 2));

        // Initialize cars
        cars.add(new Car("Car1", 5000)); // Maximum wait time: 5000 ms (5 seconds)
        cars.add(new Car("Car2", 6000)); // Maximum wait time: 6000 ms (6 seconds)
        cars.add(new Car("Car3", 4000)); // Maximum wait time: 4000 ms (4 seconds)

        logSystemEvent("Initialization complete. Starting simulation.");

        // Simulate simultaneous charging for cars based on available capacity
        for (Car car : cars) {
        	for (ChargingStation cs : chargingStations) {
                if (cs.isAvailable()) {
                    cs.occupy(car);
                    break; // Break the loop once a station is occupied
                } else {
                    LOGGER.info("No available slots at station " + cs.getLocation() + " for " + car.getName());
                }
            }
        }

        logSystemEvent("Simulation complete. Exiting program.");
    }

    private static void logSystemEvent(String logMessage) {
        LOGGER.info(logMessage);
    }
}
