package kafka.com.in.response;

public class ResponseError {
	public String message;
	public int status_code;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getStatus_code() {
		return status_code;
	}
	public void setStatus_code(int status_code) {
		this.status_code = status_code;
	}
	
	public ResponseError(String message, int status_code) {
		super();
		this.message = message;
		this.status_code = status_code;
	}
	@Override
	public String toString() {
		return "ResponseError [message=" + message + ", status_code=" + status_code + "]";
	}
	public ResponseError() {
		
	}

}
