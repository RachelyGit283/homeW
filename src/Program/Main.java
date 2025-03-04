package Program;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.Scanner;

import business.InquiryHandling;
import business.InquiryManager;

public class Main {

	public static void main(String[] args) throws Exception {
		File f= new File("./ll.txt");
		OutputStream os=new FileOutputStream(f);
		OutputStreamWriter outputStreamWriter=new OutputStreamWriter(os);
		outputStreamWriter.write(".getData()");
		outputStreamWriter.flush();
		//f=null;
	//	f= new File("./ll.txt");
		outputStreamWriter.write(".getData()");
		outputStreamWriter.close();
		os.close();
		boolean b=f.delete();
//		InquiryHandling handling1 = new InquiryHandling();
//		Thread handling2 = new InquiryHandling();
//		InquiryHandling handling3 = new InquiryHandling();
//		InquiryHandling handling4 = new InquiryHandling();
//		handling1.createInquiry();
//		((InquiryHandling) handling2).createInquiry();
//		handling3.createInquiry();
//		handling4.createInquiry();
	
		// first running
//		handling1.start();
//		handling2.start();
//		handling3.start();
//		handling4.start();
		// second running		
//		handling1.run();
//		handling2.run();
//		handling3.run();
//		handling4.run();

		
//		InquiryHandling []a=new InquiryHandling[15];
//		for (int i=0;i<15;i++) {
//			a[i]=new InquiryHandling();
//			a[i].createInquiry();
//		}
//		for (int i=0;i<15;i++) {
//			a[i].start();
//		}
		
		InquiryManager inquiryManager = new InquiryManager();
		inquiryManager.inquiryCreation();
		inquiryManager.start();


	}

}
