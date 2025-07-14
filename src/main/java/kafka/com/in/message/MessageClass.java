package kafka.com.in.message;

import org.springframework.stereotype.Component;

@Component
public class MessageClass {
	
	 String message;
	public String getMessage() {
		if (message == null) {
			return "No message received yet";
		}System.out.println(message);
		return message;
	}
	public void setMessage(String message) {
		System.out.println("Message set to: " + message);
		this.message = message;
	}
	
	
	
	
	
	public MessageClass() {
	
	}

}
