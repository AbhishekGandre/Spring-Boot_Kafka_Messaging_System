package kafka.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import kafka.com.in.entity.KafkaMessengerUser;


@EnableJpaRepositories
@SpringBootApplication
public class SbKafkaMessengerApplication {
	public static void main(String[] args) {
		SpringApplication.run(SbKafkaMessengerApplication.class, args);
		System.out.println("Spring Boot Kafka Messenger Application Started");;
	}

}
