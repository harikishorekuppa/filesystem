package com.alca.inmem.operations;

import com.alca.inmem.structures.Directory;

public interface DirectoryOps {

	public Directory createDir(String name, Directory currentDir);
	public void removeDir(String name);
	public void createFile(Directory currentDir, String name, Object content);
	public Directory navigate(String path, Directory currentDir);
	public void getDirFromPath(String path);
	public void listFiles(Directory dir);
	public String getFullPath(Directory currentDir);
}
