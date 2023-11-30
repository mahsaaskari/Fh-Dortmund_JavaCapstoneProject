import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Logger;

// available resources = charging stations and their capacity
public class ChargingStation implements Serializable {
	private static final Logger LOGGER = Logger.getLogger(ChargingStation.class.getName());

    private int location;
    private boolean available;
    private int maxCapacity; // Maximum charging capacity of the station
    private int currentCapacity; // Current available charging slots

    public ChargingStation(int location, int maxCapacity) {
        this.location = location;
        this.maxCapacity = maxCapacity;
        this.available = true;
        this.currentCapacity = maxCapacity;
    }

    public synchronized void occupy(Car car) {
        if (currentCapacity > 0) {
            currentCapacity--;
            this.available = false;
            LOGGER.info(car.getName() + " occupied station " + location );
        } else {
            LOGGER.info("No available slots at station " + location + " for " + car.getName());
        }
    }

    public synchronized void release() {
        this.available = true;
        currentCapacity++;
        LOGGER.info("Charging station at location " + location + " released.");
    }
    
    public synchronized boolean isAvailable() {
        return currentCapacity > 0; // Check if there are available slots for charging
    }
    
    public synchronized boolean getLocation() {
        return location > 0; // Check if there are available slots for charging
    } 

}
