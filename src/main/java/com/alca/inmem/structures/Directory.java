package com.alca.inmem.structures;

import java.util.HashMap;
import java.util.Map;

public class Directory {
	private String name;
	private Directory parentDir;
	private Map<String, Directory> childDirs = new HashMap<>();
	private Map<String, File> files = new HashMap<>();
	
	public Directory(String name, Directory parentDir) {
		super();
		this.name = name;
		this.parentDir = parentDir;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Directory getParentDir() {
		return parentDir;
	}
	public void setParentDir(Directory parentDir) {
		this.parentDir = parentDir;
	}
	public Map<String, Directory> getChildDirs() {
		return childDirs;
	}
	public void setChildDirs(Map<String, Directory> childDirs) {
		this.childDirs = childDirs;
	}
	public Map<String, File> getFiles() {
		return files;
	}
	public void setFiles(Map<String, File> files) {
		this.files = files;
	}
	
}
