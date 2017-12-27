package com.alca.inmem.operations;

import com.alca.inmem.structures.File;

public class JsonFileCreator implements FileOperations{

	@Override
	public File createFile(String name, Object content) {
		File newFile = new File(name, content);
		return newFile;
	}

}
