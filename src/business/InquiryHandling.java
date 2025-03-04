package business;
 
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import Data.Complaint;
import Data.Inquiry;
import Data.Question;
import Data.Request;
import Exception.InquiryException;
import Exception.InquiryRunTimeException;
import HandleStoreFiles.HandleFiles;

public class InquiryHandling extends Thread  {
	private Inquiry currentInquiry;
	HandleFiles handleFiles = new HandleFiles();
	Scanner scanner =new Scanner(System.in);
	private int time=5;
	//private String type;
	Random rand=new Random();
	
	public void createInquiry() throws Exception {
		System.out.println("Enter 1 for question, 2 for request and 3 for complaint");
		int num=scanner.nextInt();
		while (!(num>0&&num<4)) {
			System.out.println("Enter 1 for question, 2 for request and 3 for complaint");
			num=scanner.nextInt();
		}
		switch (num) {
		case 1: {
			time=rand.nextInt(1, 5);
			currentInquiry=new Question();
			break;
		}
		case 2:{
			time=rand.nextInt(10, 15);
			this.setPriority(MIN_PRIORITY);
			currentInquiry=new Request();
			break;
		}
		default:{
			time=rand.nextInt(20, 40);
			currentInquiry=new Complaint();
			break;
		}
		}
		currentInquiry.fillDataByUser();
		handleFiles.saveFile(currentInquiry);
		List ll=currentInquiry.getL();
		ll.add(currentInquiry.getFileName());
		currentInquiry.setL(ll);

	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	@Override
	public void run() {
		try {
			System.out.println(this.getClass().getSimpleName()+" Number "+currentInquiry.getCode()+" assume time "+time+" seconds");
		if(time>5&&Thread.currentThread().activeCount()>10)
			Thread.currentThread().yield();
		try {
			Thread.currentThread().sleep(time*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}}
		
		catch(Exception e) {
			throw new InquiryRunTimeException(currentInquiry.getCode());

		}
		
		
		currentInquiry.handling();
	}
}
