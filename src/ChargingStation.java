import java.io.BufferedWriter;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.concurrent.TimeUnit;

// available resources = charging stations and their capacity
public class ChargingStation implements Serializable {
	private static final Logger LOGGER = Logger.getLogger(ChargingStation.class.getName());
	 private static final int MAX_WAIT_TIME = 15; // Maximum wait time in minutes
	 private final Lock lock = new ReentrantLock();
	 
    private String location;
    private boolean available;
    private int maxCapacity; // Maximum charging capacity of the station
    private int currentCapacity; // Current available charging slots
    private List<Car> queue;

    public ChargingStation(String location, int maxCapacity) {
        this.location = location;
        this.maxCapacity = maxCapacity;
        this.available = true;
        this.currentCapacity = maxCapacity;
        this.queue = new ArrayList<>();
    }
    
   

    public void chargeBattery(ReservedBattery battery, EnergySource energySource) {
        lock.lock();
        try {
            LOGGER.info("Charging battery " + battery.getId() + " with " + energySource + " energy source.");
            // Simulating charging process
            Thread.sleep(3000); // Charging time (in milliseconds)
            LOGGER.info("Battery " + battery.getId() + " charged successfully.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
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
    
//    public synchronized boolean getLocation() {
//        return location > 0; // Check if there are available slots for charging
//    } 
    
    public String getLocation() {
        return location;
    }

    public synchronized int addToQueue(Car car) {
    	   int waitingTime = queue.size() * 5; // Calculate waiting time (5 seconds per car in queue)
           queue.add(car);
           return waitingTime;
    }
    
    public synchronized void simulateArrival(Car car) {
        int waitingTime = addToQueue(car); // Add car to the station's queue

        try {
            if (waitingTime > MAX_WAIT_TIME * 60) {
                LOGGER.info(car.getName() + " waited more than " + MAX_WAIT_TIME + " minutes and left the queue.");
            } else {
                LOGGER.info(car.getName() + " is waiting at station " + getLocation() + ". Waiting time: " + waitingTime / 60 + " minutes");
                TimeUnit.SECONDS.sleep(5); // Simulating charging time
                queue.remove(car); // Car finished charging, remove from queue
                LOGGER.info(car.getName() + " finished charging and left the station.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
