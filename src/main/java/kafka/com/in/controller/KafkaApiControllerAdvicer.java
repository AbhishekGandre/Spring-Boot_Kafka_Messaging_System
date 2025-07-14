package kafka.com.in.controller;

import org.apache.kafka.common.errors.TopicExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;



@RestControllerAdvice
public class KafkaApiControllerAdvicer {

	@ExceptionHandler(TopicExistsException.class)
	public ResponseEntity<Object> TopicExistsException(Exception ex) {
		return ResponseEntity.status(HttpStatus.CONFLICT).body("{\"message\": \"Topic already exists:" + ex.getMessage() + "\"}");
	}
	
	
	@ExceptionHandler(NoResourceFoundException.class)
	public ResponseEntity<Object> NoResourceFoundException(Exception ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"message\":\"Not Found\"" + ex.getMessage()+ "\"}");
	}
	
	public KafkaApiControllerAdvicer() {
		// TODO Auto-generated constructor stub
	}

}
