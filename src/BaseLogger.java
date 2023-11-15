import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BaseLogger {
//	normal log
	public void log(String message) {
		System.out.println(message);
	}
	
//	using char and byte stream
	public void logActivity(String message) {
		System.out.println(message);
	}
}
