package TestSaveFile;

import java.util.Arrays;

import HandleStoreFiles.HandleFiles;

public class TestingHandleFiles {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		PersonForTestSaving p1 = new PersonForTestSaving("1234","aaa");
		HandleFiles i=new HandleFiles();
		Object [] fields=p1.getClass().getDeclaredFields();
		Object l=new Object();
		boolean b=fields[2].getClass().isInstance(l);
//		PersonForTestSaving p2 = new PersonForTestSaving("5432","bbb");
//		PersonForTestSaving p3 = new PersonForTestSaving("9999","ccc");
//		PersonForTestSaving p4 = new PersonForTestSaving("0090","ccdc");
//		
//		HandleFiles handleFiles = new HandleFiles();
//		handleFiles.saveFile(p3);
//		handleFiles.saveFiles(Arrays.asList(p1,p2,p3,p4));
//		
//		handleFiles.deleteFile(p2);

  	}

}
