package com.alca.inmem.operations;

public class FileExtensionFactory {

	/**
	 * if there is no extension or unknown extension, create text file by default.
	 * returns file creator by extension
	 * 
	 * @param name : name with extension-> 1.txt
	 * @return
	 */
	public FileOperations getFileConstruct( String name){
		String extension = name.trim().split("//.")[0];
		FileOperations fileCreator =null;
		if(extension!= null){
			if(extension.equals("txt")){
				fileCreator = new TextFileCreator();
			}else if(extension.equals("json")){
				fileCreator = new JsonFileCreator();
			}else
				fileCreator = new TextFileCreator();
		}else{
			fileCreator = new TextFileCreator();
		}
		return fileCreator;
	}
}
