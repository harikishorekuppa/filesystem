package com.alca.inmem.operations;

import java.util.Optional;

import com.alca.inmem.structures.Directory;
import com.alca.inmem.structures.File;

public class DirectoryOpsImpl implements DirectoryOps{

	@Override
	public Directory createDir(String name, Directory currentDir) {
		Directory newDir = new Directory(name, currentDir);
		Optional.ofNullable(currentDir).ifPresent(d->d.getChildDirs().put(name, newDir));
		return newDir;
	}

	@Override
	public void removeDir(String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public void createFile(Directory currentDir, String name, Object content) {

		File newFile = new FileExtensionFactory().getFileConstruct(name).createFile(name, content);
		currentDir.getFiles().put(name, newFile);

	}

	@Override
	public void getDirFromPath(String path) {
		// TODO Auto-generated method stub

	}

	@Override
	public void listFiles(Directory dir) {

		System.out.println("path: "+getFullPath(dir));
		if(dir.getChildDirs().size()==0 && dir.getFiles().size()==0){
			System.out.println("No files or directories found!");
		}else{
			dir.getChildDirs().forEach((name,directory)->{System.out.println(name+ "/");});
			dir.getFiles().forEach((name,files)->{System.out.println(name);});
		}
	}

	@Override
	public Directory navigate(String path, Directory currentDir) {
		Directory navigatedDir;
		//		System.out.println("path: "+getFullPath(currentDir));
		if(path.matches("\\.\\.")){
//			System.out.println("path ..");
			navigatedDir = currentDir.getParentDir();
//			System.out.println(navigatedDir);
		}else
			navigatedDir = currentDir.getChildDirs().get(path);

		return navigatedDir;
	}

	public String getFullPath(Directory dir){
		Directory parentDir = dir.getParentDir();
		String path =dir.getName();
		while(parentDir != null){
			path = parentDir.getName()+"/"+path;
			parentDir =  parentDir.getParentDir();
		}
		return path+"/";
	}
}
