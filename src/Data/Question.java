package Data;

import java.time.LocalDateTime;

public class Question extends Inquiry {
	public void handling() {
		System.out.print("Question ");
		super.handling();
	}
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Question(Integer code, String description, LocalDateTime creationDate) {
		super( code, description, creationDate,"Question");
	}
}
