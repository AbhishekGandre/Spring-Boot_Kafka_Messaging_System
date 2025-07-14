package kafka.com.in.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.validation.Valid;
import kafka.com.in.consumer.KafkaConsumerService;
import kafka.com.in.entity.JpaDaoRepository;
import kafka.com.in.entity.KafkaMessengerUser;
import kafka.com.in.message.MessageClass;
import kafka.com.in.producer.KafkaProducerService;
import kafka.com.in.topic.Topic;
import kafka.com.in.topic.Topic_Builder;

@PropertySource("classpath:application.properties")
@Controller
@RequestMapping("/kafka")
public class KafkaApiController {

	@Autowired
	KafkaProducerService producer;


//=============================Topic code ====================================
	@ResponseBody
	@PostMapping(path = "/topic", produces = "application/json")
	public ResponseEntity<?> getKafkaTopic(@RequestBody Topic tp) throws InterruptedException, ExecutionException {
		String topicFlag = Topic_Builder.topicBuilder(tp.getTopic());
		return ResponseEntity.status(HttpStatusCode.valueOf(201)).body("\"message\": \"" + topicFlag + "\"");
	}

//=============================consumer code ====================================
	@Autowired
	KafkaConsumerService kafkaConsumerService;

	@ResponseBody
	@GetMapping(path = "/message", produces = "application/json")
	public ResponseEntity<?> getKafkaMessage(@RequestBody Topic tp) throws InterruptedException {

		return kafkaConsumerService.messageListenerContainer(tp.getTopic());

	}

	@ResponseBody
	@GetMapping(path = "/getallmessages", produces = "application/json")
	public ResponseEntity<?> getAllKafkaMessage(@Valid @RequestBody Topic tp) throws InterruptedException {

		ArrayList<String> records =kafkaConsumerService.startManualConsumer(tp.getTopic(),tp.getGroupId());
		if (records.isEmpty()) {
			return ResponseEntity.status(HttpStatusCode.valueOf(404)).body("{\"message\": \"No messages found\"}");
		}

		return ResponseEntity.ok().body("{\"message\": \"" + records+ "\"}");

	}

//	==============================producer code ====================================
	MessageClass msgclass;

	public KafkaApiController(MessageClass msgclass) {
		this.msgclass = msgclass;
	}

	@ResponseBody
	@PostMapping(path = "/message", produces = "application/json")
	public ResponseEntity<?> setKafkaMessage(@RequestBody MessageClass msg) {
		String message = msg.getMessage();
		boolean producerFlag = producer.KafkaMessageSender(message, "topic-no1");
		if (!producerFlag) {
			msgclass.setMessage("'" + message + "' " + "message sent failed");
			return ResponseEntity.badRequest().body(msgclass);

		}
		msgclass.setMessage("'" + message + "' " + "message sent successfully");
		return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(msgclass);
	}

//===================================user code ====================================
	@Autowired
	JpaDaoRepository jpaDaoRepository;

	@ResponseBody
	@GetMapping(path = "/getallusers", produces = "application/json")
	public ResponseEntity<?> getAllUsers() {
		List<KafkaMessengerUser> user = jpaDaoRepository.findAll();
		for (KafkaMessengerUser kafkaMessengerUser : user) {
			kafkaMessengerUser.setUserPassword("*************");
		}
		return ResponseEntity.ok().body(user);
	}

	@PostMapping(path = "/adduser")
	public ResponseEntity<?> addUser(@Valid @RequestBody KafkaMessengerUser user, BindingResult br) {
		KafkaMessengerUser result = jpaDaoRepository.save(user);
		result.setUserPassword("*************");
		return ResponseEntity.ok().body(result);
	}

	@GetMapping(path = "/getuserbyid", produces = "application/json")
	public ResponseEntity<?> getUserById(@RequestBody KafkaMessengerUser user) {
		long userId = user.getUserId();
		KafkaMessengerUser result = jpaDaoRepository.findById(userId).orElse(null);
		if (result == null) {
			return ResponseEntity.status(HttpStatusCode.valueOf(404)).body("User not found");
		}
		result.setUserPassword("*************");
		return ResponseEntity.ok().body(result);
	}

	@GetMapping(path = "/getuserbynumber", produces = "application/json")
	public ResponseEntity<?> getUserByNumber(@RequestBody KafkaMessengerUser user) {
		String number = user.getUserPhoneNumber();
		List<KafkaMessengerUser> result = jpaDaoRepository.getByUserPhoneNumber(number);
		if (result == null) {
			return ResponseEntity.status(HttpStatusCode.valueOf(404)).body("User not found");
		}
		for (KafkaMessengerUser kafkaMessengerUser : result) {
			kafkaMessengerUser.setUserPassword("*************");
		}
		return ResponseEntity.ok().body(result);
	}

	@DeleteMapping(path = "/deleteuserbyid", produces = "application/json")
	public ResponseEntity<?> deleteUserById(@RequestBody KafkaMessengerUser user) {
		long userId = user.getUserId();
		if (!jpaDaoRepository.existsById(userId)) {
			return ResponseEntity.status(HttpStatusCode.valueOf(404)).body("User not found");
		}
		jpaDaoRepository.deleteById(userId);
		return ResponseEntity.ok().body("User with ID " + userId + " deleted successfully");
	}

	@DeleteMapping(path = "/deleteuserbynumber", produces = "application/json")
	public ResponseEntity<?> deleteUserByNumber(@RequestBody KafkaMessengerUser user) {
		String number = user.getUserPhoneNumber();
		List<KafkaMessengerUser> users = jpaDaoRepository.getByUserPhoneNumber(number);
		if (users.isEmpty()) {
			return ResponseEntity.status(HttpStatusCode.valueOf(404)).body("User not found");
		}
		for (KafkaMessengerUser kafkaMessengerUser : users) {
			jpaDaoRepository.delete(kafkaMessengerUser);
		}
		return ResponseEntity.ok().body("Users with phone number " + number + " deleted successfully");
	}

	@DeleteMapping(path = "/deleteallusers", produces = "application/json")
	public ResponseEntity<?> deleteAllUsers() {
		List<KafkaMessengerUser> users = jpaDaoRepository.findAll();
		if (users.isEmpty()) {
			return ResponseEntity.status(HttpStatusCode.valueOf(404)).body("No users found to delete");
		}
		jpaDaoRepository.deleteAll(users);
		return ResponseEntity.ok().body("All users deleted successfully");
	}

	@PutMapping(path = "/updateuser", produces = "application/json")
	public ResponseEntity<?> updateUser(@Valid @RequestBody KafkaMessengerUser user, BindingResult br) {
		if (!jpaDaoRepository.existsById(user.getUserId())) {
			return ResponseEntity.status(HttpStatusCode.valueOf(404)).body("User not found");
		}
		 LocalDateTime currentDate = LocalDateTime.now() ;
		user.setModificationDate(currentDate);
		KafkaMessengerUser result = jpaDaoRepository.findById(user.getUserId()).orElse(null);
		user.setCreatedDate(result.getCreatedDate());
		KafkaMessengerUser updatedUser = jpaDaoRepository.save(user);
		updatedUser.setUserPassword("*************");
		return ResponseEntity.ok().body(updatedUser);
	}

}
