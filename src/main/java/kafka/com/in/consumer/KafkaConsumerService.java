package kafka.com.in.consumer;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.stereotype.Service;



@Service
public class KafkaConsumerService {

//	@KafkaListener(topics = "my-topic1", id = "demo", groupId = "demo")
//	public void listen(String message) {
//		System.out.println("Received@: " + message);
//	}

	public String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String msg) {
		
		
		this.message = msg;
		System.out.println("Setting message consumer: " + message);
		System.out.println("Setting message consumer: " + msg);
	}


	public ResponseEntity<?> messageListenerContainer(String topic) throws InterruptedException {
	    CountDownLatch latch = new CountDownLatch(1);

	    ContainerProperties containerProps = new ContainerProperties(topic);
	    containerProps.setMessageListener((MessageListener<String, String>) message -> {
	        setMessage(message.value());
	        latch.countDown(); 
	    });

	    KafkaMessageListenerContainer<String, String> container = new KafkaMessageListenerContainer<>(
	        KafkaConsumerConfig.consumerFactory(), containerProps);
	    
	    container.start();

	    // Wait for message or timeout after 5 seconds
	    boolean received = latch.await(50, TimeUnit.MILLISECONDS);

	    container.stop();

	    if (received) {
	        return ResponseEntity.ok().body("{\"message\": \"" + getMessage() + "\"}");
	    } else if(getMessage() != null){return ResponseEntity.ok().body("{\"message\": \"" + getMessage() + "\"}");}
	    else {
	        return ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT).body("{\"error\": \"No message received in time\"}");
	    }
	}

	public KafkaConsumerService() {

	}

	public ArrayList<String> startManualConsumer(String topicName, String groupId) throws InterruptedException {
	    Properties props = new Properties();
	    props.put("bootstrap.servers", "localhost:9092");
	    props.put("group.id", groupId);
	    props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
	    props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
	    props.put("auto.offset.reset", "earliest");

	    KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
	    consumer.subscribe(Collections.singletonList(topicName));
	   
	   ArrayList<String> messages = new ArrayList<>();
	    	ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
	    	
	        	
	        	if (records.isEmpty()) {
					System.out.println("No records received yet");
				}
				for (ConsumerRecord<String, String> record : records) {
					messages.add(record.value());
					System.out.println("Received record: " + record.value());
				}

				
				System.out.println();
				System.out.println("Finished processing records, closing consumer");
				consumer.close();
				return messages;
	        }
	    
	}
	
	


