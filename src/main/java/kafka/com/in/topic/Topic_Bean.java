package kafka.com.in.topic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class Topic_Bean {

	
	@Bean
	Topic_Builder topicBuild() {
		return new Topic_Builder();
	}
}
