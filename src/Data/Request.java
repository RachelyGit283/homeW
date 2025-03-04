package Data;

import java.time.LocalDateTime;

public class Request extends Inquiry{
	public void handling() {
		System.out.print("Request ");
		super.handling();
	}
	public Request(Integer code, String description, LocalDateTime creationDate) {
		super( code, description, creationDate,"Request");
	}
	public Request() {
		super();
		// TODO Auto-generated constructor stub
	}
}
