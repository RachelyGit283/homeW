package HandleStoreFiles;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Scanner;

import Exception.InquiryRunTimeException;

public class HandleFiles {
	public void saveFile(ForSaving forSaving) throws Exception {
		try {
		File f= new File(forSaving.getFolderName()+'/'+forSaving.getFileName());
		OutputStream os=new FileOutputStream(f);
		OutputStreamWriter outputStreamWriter=new OutputStreamWriter(os);
		outputStreamWriter.write(forSaving.getData());
		outputStreamWriter.flush();
		outputStreamWriter.close();
		os.close();
		}
		catch(Exception e) {
			int code=Integer.parseInt(forSaving.getData().split(",")[1]);
			throw new InquiryRunTimeException(code);
		}
	}
	public void deleteFile(ForSaving forSaving) {
		File f= new File(forSaving.getFolderName()+'/'+forSaving.getFileName());
		f.delete();
		}
	public void updateFile(ForSaving forSaving) throws IOException {
		File f= new File(forSaving.getFolderName()+'/'+forSaving.getFileName());
		OutputStream os=new FileOutputStream(f,true);
		OutputStreamWriter outputStreamWriter=new OutputStreamWriter(os);
		outputStreamWriter.append(forSaving.getData());
		outputStreamWriter.flush();
		outputStreamWriter.close();
		os.close();
	}
	private void getFileName(ForSaving forSaving) {
		System.out.println("Enter file name:");
		Scanner scanner=new Scanner(System.in);
		String n=scanner.nextLine();

	}
	public void saveFiles(List forSavingList) throws Exception {
		for (Object object : forSavingList) {
			if (object instanceof ForSaving)
				this.saveFile((ForSaving)object);
			
		}
	}
	public String getCSVDataRecursive(Object obj) {
		String data="";
		Object [] fields=obj.getClass().getDeclaredFields();
		return "helllo";
	}

}
