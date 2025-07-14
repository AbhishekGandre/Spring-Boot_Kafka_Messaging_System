package kafka.com.in.topic;

import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;

import org.springframework.stereotype.Service;



@Service
public class Topic_Builder {
	 static Logger log = Logger.getLogger(Topic_Builder.class.getName());
	
	
	public static String topicBuilder(String topic) throws InterruptedException, ExecutionException {
		
		String bootstrapServers = "localhost:9092";
	
		String topicName = topic;
			log.info("topic name : "+topic);
	
		Properties config = new Properties();
		config.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);

		try (AdminClient admin = AdminClient.create(config)) {

//	        	Both the method work well for creating topic 
			NewTopic newTopic = new NewTopic(topicName, 1, (short) 1);
//	            NewTopic newTopic = TopicBuilder.name(topicName).build();

			admin.createTopics(Collections.singleton(newTopic)).all().get();

//		} catch (Exception e) {
//			log.info(e.getMessage());
//			return e.getMessage();
		}
		log.info("Topic created successfully.");
		return "Topic created successfully.";
	}

//	public static void main(String[] args) throws InterruptedException, ExecutionException {
//
//		String bootstrapServers = "localhost:9092";
//		String topicName = "my-topic";
//
//		Properties config = new Properties();
//		config.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
//
//		try (AdminClient admin = AdminClient.create(config)) {
//
////	        	Both the method work well for creating topic 
//			NewTopic newTopic = new NewTopic(topicName, 1, (short) 1);
////	            NewTopic newTopic = TopicBuilder.name(topicName).build();
//
//			admin.createTopics(Collections.singleton(newTopic)).all().get();
//
//			System.out.println("Topic created successfully.");
//		}
//	}

}
