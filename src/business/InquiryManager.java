package business;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

import Data.Complaint;
import Data.Inquiry;
import Data.Question;
import Data.Request;
import Exception.InquiryException;
import Exception.InquiryRunTimeException;
import HandleStoreFiles.HandleFiles;
import business.InquiryHandling;
import java.io.File;
public class InquiryManager extends Thread{
	private Queue<InquiryHandling> q=new LinkedList<InquiryHandling>();
	private List<Inquiry> savedInquery=new LinkedList<Inquiry>();
	private Inquiry currentInquiry;
	private HandleFiles handleFiles=new HandleFiles();
	Random rand=new Random();
	String s;
	Scanner scanner=new Scanner(System.in);
	private int time=5;
	public void inquiryCreation() throws Exception {
		System.out.println("Enter yes or exit if you want to stop");

		s=scanner.next();
		InquiryHandling n;
		while(!s.equals("exit")) {
			n=new InquiryHandling();
			n.createInquiry();
			q.add(n);
			System.out.println("Enter yes or exit if you want to stop");
			s=scanner.next();
		}
	}
	public List<Inquiry> readInquiryFromFiles() throws IOException {
		List<Inquiry>q=new ArrayList<Inquiry>();
		try {
		File directory = new File("./Inquiry");
	    File[] files = directory.listFiles();
	      if (files != null) {
	        for (File file : files) {
	  	      File[] inquiries = file.listFiles();
	  	      for (File inquiry : inquiries) {
	  	    	BufferedReader br = new BufferedReader(new FileReader(inquiry));
	  	    	try {
	  	    	    StringBuilder sb = new StringBuilder();
	  	    	    String line = br.readLine();
	  	    	    while (line != null) {
	  	    	        System.out.println("loading "+line);
	  	    	        String [] ditels=line.split(",");
	  	    	      int code=-1;
	  	    	    LocalDateTime creationDate;
	  	    	      try {
		  	    	       creationDate= LocalDateTime.parse(ditels[2]);

	  	    	      }
	  	    	      catch(Exception e) {
	  	    	    	  throw new InquiryException(code);
	  	    	      }
		  	    	    	code = Integer.parseInt(ditels[1]);
	  	    	        Inquiry inq;
	  	    	        switch (ditels[0]) {
						case "Request": {
							inq=new Request(code,ditels[3],creationDate);
							break;
						}
						case "Question": {
							inq=new Question(code,ditels[3],creationDate);
							break;
						}
						default:
							inq=new Complaint(code,ditels[3],creationDate,ditels[4]);
						}
	  	    	        q.add(inq);
	  	    	     line = br.readLine();
	  	    	    }
	  	    	} finally {
	  	    	    br.close();
	  	    	}
	  	      }
	        }
	      }
		}
		catch(Exception e) {
			throw new InquiryRunTimeException(-1);
		}
	      
	      return q;
	    }
	
	public void processInquiryManager() {
		File f=new File("./Complaint");
		
		while(!q.isEmpty()) {
			q.remove().start();
		}
	}
	public void run() {
		try {
			savedInquery=readInquiryFromFiles();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		processInquiryManager();
	}
}
