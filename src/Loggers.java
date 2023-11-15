import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

class ChargingStationLoggers extends BaseLogger  {
	 @Override
	 public void log(String message) {
		 super.log("ChargingStationLogger: " + message);
	 }
	 
	 @Override
	 public void logActivity(String message) {
		 super.log("ChargingStationLogger: " + message);
		  try (BufferedWriter writer = new BufferedWriter(new FileWriter("charging_station_log.txt", true))) {
	            writer.write(message);
	            writer.newLine();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	 }
}

class EnergyManagementSystemLoggers extends BaseLogger {
	 @Override
	 public void log(String message) {
		 super.log("EnergyManagementSystemLoggers: " + message);
	 }
	 
	 @Override
	 public void logActivity(String message) {
		 super.log("EnergyManagementSystemLoggers: " + message);
		  try (BufferedWriter writer = new BufferedWriter(new FileWriter("energy_management_system_log.txt", true))) {
	            writer.write(message);
	            writer.newLine();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	 }
}

class UsersLoggers extends BaseLogger {
	 @Override
	 public void log(String message) {
		 super.log("UsersLoggers: " + message);
	 }
	 
	 @Override
	 public void logActivity(String message) {
		 super.log("UsersLoggers: " + message);
		  try (BufferedWriter writer = new BufferedWriter(new FileWriter("users_log.txt", true))) {
	            writer.write(message);
	            writer.newLine();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	 }
}

// we will be adding more as project develops
