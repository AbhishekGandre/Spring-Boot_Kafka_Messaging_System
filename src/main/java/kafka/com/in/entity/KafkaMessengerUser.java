package kafka.com.in.entity;

import java.time.LocalDateTime;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "kafka_messenger_user")
public class KafkaMessengerUser {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id", unique = true, nullable = false)
	long userId;

	@Pattern(regexp = "^[A-Za-z]+(?:\\s[A-Za-z]+)+$", message = "name should contain only alphabets")
	@NotBlank(message = "name is mandatory")
	@Size(min = 1, max = 100)
	@Column(name = "user_name", nullable = false, unique = true)
	String userName;

	@NotBlank(message = "email is mandatory")
	@Email(message = "email should be valid")
	@Column(name = "user_email", unique = true, nullable = false)
	String userEmail;

	@Column(name = "user_password", nullable = false)
	String userPassword;
	
	 @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be 10 digits")
	@Column(name = "user_phone_number", nullable = false, unique = true)
	String userPhoneNumber;

	@Column(name = "admin_or_not")
	boolean admin;

	@Column(name = "CREATION_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	public LocalDateTime createdDate = LocalDateTime.now() ;

	@Column(name = "MODIFICATION_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	public LocalDateTime modificationDate;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}

	public void setUserPhoneNumber( String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getModificationDate() {
		return modificationDate;
	}

	public void setModificationDate(LocalDateTime modificationDate) {
		this.modificationDate = modificationDate;
	}

	public KafkaMessengerUser(long userId,
			@Pattern(regexp = "^[A-Za-z]+(?:\\s[A-Za-z]+)+$", message = "name should contain only alphabets") @NotBlank(message = "name is mandatory") @Size(min = 1, max = 100) String userName,
			@NotBlank(message = "email is mandatory") @Email(message = "email should be valid") String userEmail,
			String userPassword, @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be 10 digits") String userPhoneNumber, boolean admin, LocalDateTime createdDate, LocalDateTime modificationDate) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userPhoneNumber = userPhoneNumber;
		this.admin = admin;
		this.createdDate = createdDate;
		this.modificationDate = modificationDate;
	}

	@Override
	public String toString() {
		return "KafkaMessengerUser [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail
				+ ", userPassword=" + userPassword + ", userPhoneNumber=" + userPhoneNumber + ", admin=" + admin
				+ ", createdDate=" + createdDate + ", modificationDate=" + modificationDate + "]";
	}
	
	public KafkaMessengerUser() {
		
	}

}
