package TestSaveFile;

import HandleStoreFiles.ForSaving;
import HandleStoreFiles.HandleFiles;

public class PersonForTestSaving implements ForSaving{
	String id;
	String name;
	HandleFiles h=new HandleFiles();
	public PersonForTestSaving(String id,String name) {
		this.id=id;
		this.name=name;
		}

	@Override
	public String getFolderName() {
		return getClass().getPackageName();
	}

	@Override
	public String getFileName() {
		return getClass().getPackageName()+id;

	}

	@Override
	public String getData() {
		return id+","+name;
	}
	
}
