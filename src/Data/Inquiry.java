package Data;

import java.nio.file.DirectoryIteratorException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.naming.spi.DirectoryManager;
import javax.swing.plaf.basic.BasicDirectoryModel;

import HandleStoreFiles.ForSaving;
import HandleStoreFiles.HandleFiles;

import java.io.File;

public class Inquiry implements ForSaving {
	static Integer nextCodeVal = 0;
	private Integer code;
	private String description;
	private LocalDateTime creationDate;
	private String className;
	private List l;
	public List getL() {
		List ll=new ArrayList<String>(l);
		return ll;
	}
	public void setL(List l) {
		List ll=new ArrayList<String>(l);

		this.l = ll;
	}
	Scanner scanner=new Scanner(System.in);
	public Inquiry() {
		className=this.getClass().getSimpleName();
	}
	public void fillDataByUser() {
		creationDate=LocalDateTime.now();
		nextCodeVal++;
		code=nextCodeVal;
		System.out.println("Enter descripition: ");
		String d=scanner.nextLine();
		description=d;
		l=new ArrayList<String>();
		}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDateTime getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}
	
	public void handling() {
		System.out.println("number "+this.code);
	}
	@Override
	public String getFolderName() {
		File d=new File("Inquiry/"+this.getClass().getSimpleName());
		boolean b=d.isDirectory();
		if (!b) {
			b=d.mkdirs();
		}
		// TODO Auto-generated method stub
		return d.getPath();
	}
	public Inquiry(Integer code, String description, LocalDateTime creationDate, String className) {
		super();
		this.code = code;
		this.description = description;
		this.creationDate = creationDate;
		this.className = className;
		
	}
	@Override
	public String getFileName() {
		char c='n';
		if (this instanceof Complaint)
			c='C';
		else if (this instanceof Request)
			c='R';
		else if (this instanceof Question)
			c='Q';
		// TODO Auto-generated method stub
		return c+this.code.toString()+".csv";
	}
	@Override
	public String getData() {
		// TODO Auto-generated method stub
		String data=this.className+","+this.code.toString()+","+this.creationDate.toString()+","+this.description;

		return data;
	}
}
