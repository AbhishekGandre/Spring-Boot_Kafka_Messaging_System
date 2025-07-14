package kafka.com.in.producer;


import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

	Logger log= Logger.getLogger(KafkaProducerService.class.getName());
	
	@Autowired
	KafkaTemplate<String, String> kafkatemplate;
	
	
	public KafkaProducerService(KafkaTemplate<String, String> kafkatemplate) {
		this.kafkatemplate = kafkatemplate;
		
	}
	
	

	
	public KafkaProducerService() {
		// TODO Auto-generated constructor stub
	}




	public boolean KafkaMessageSender(String msg,String topic)  {
		try {
		log.info("Sended Message:"+msg);
		kafkatemplate.send(topic,msg);
		}
		catch(Exception e) {
			log.warning(e.getMessage());
			log.info(e.getMessage());
			return false;
		}
		
		return true;
		
	}


	

}
