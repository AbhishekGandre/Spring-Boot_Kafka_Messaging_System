package kafka.com.in.topic;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Component
public class Topic {
	
	@Pattern(regexp = "^[a-zA-Z_0-9_-]+$", message = "Please enter a valid topic name")
	@NotNull
	String topic;
	
	@Pattern(regexp = "^[a-zA-Z_0-9]+$", message = "Pleae enter a valid group id")
	@NotNull
	String groupId;

	public Topic(String topic, String groupId) {
		super();
		this.topic = topic;
		this.groupId = groupId;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getTopic() {
		return topic;
	}
	
	public void setTopic(String topic) {
		this.topic = topic;
	}

	
	@Override
	public String toString() {
		return "Topic [topic=" + topic + ", groupId=" + groupId + "]";
	}

	// Default constructor	
	public Topic() {
		
	}
	
	public Topic(String topic) {
		
		this.topic = topic;
	}
	
	

}
