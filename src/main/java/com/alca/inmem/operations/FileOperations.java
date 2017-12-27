package com.alca.inmem.operations;

import com.alca.inmem.structures.File;

public interface FileOperations {

	public File createFile(String name, Object content);
	default public void clone(String name, File from){
		//TODO implement method to create a clone of from "file" 
	}
}
