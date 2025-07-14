package kafka.com.in.entity;


import java.util.List;
import java.util.Optional;

import org.springframework.data.annotation.Persistent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Persistent
@Repository
public interface JpaDaoRepository extends JpaRepository<KafkaMessengerUser, Long> {

	List<KafkaMessengerUser> getByUserPhoneNumber(String number);
	
	
	
}


