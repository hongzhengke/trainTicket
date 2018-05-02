package trainTicket.controller;

public class ResponseEntity {
	private String message; 
	private Object data;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public ResponseEntity(String message, Object data) {
		super();
		this.message = message;
		this.data = data;
	}
	public ResponseEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
