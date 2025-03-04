package Data;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Complaint extends Inquiry {
	private String assignedBranch;
	Scanner scanner=new Scanner(System.in);
	public Complaint(Integer code, String description, LocalDateTime creationDate,String branch) {
		super( code, description, creationDate,"Complaint");
		this.assignedBranch=branch;
	}public Complaint() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void fillDataByUser() {
		System.out.println("Enter branch name:");
		assignedBranch=scanner.next();
		super.fillDataByUser();

		}
	public void handling() {
		System.out.print("Complaint ");
		super.handling();
	}
	@Override
	public String getData() {
		// TODO Auto-generated method stub

		return super.getData()+","+this.assignedBranch;
	}
}