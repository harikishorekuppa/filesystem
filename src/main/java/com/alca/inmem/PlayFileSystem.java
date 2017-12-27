package com.alca.inmem;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.alca.inmem.operations.DirectoryOps;
import com.alca.inmem.operations.DirectoryOpsImpl;
import com.alca.inmem.structures.Directory;

public class PlayFileSystem {
	String currentPath;
	static Directory currentDir;
	
	public static void main(String args[]){
		try{
			StringBuilder sb = new StringBuilder();
			sb.append("commands:").append("\n mkdir <dirname>").append("\n cd <path>").append("\n ls .").append("\n pwd").append("exit");
			System.out.println(sb.toString());
			System.out.println("Please enter any of the above listed commands to get the feel of unix file system.");

			DirectoryOps dirOps = new DirectoryOpsImpl();
			Directory rootDir = dirOps.createDir("root", null);
			dirOps.createFile(rootDir, "1.txt", "hello");
			dirOps.createFile(rootDir, "2.txt", "hi");
//			dirOps.listFiles(rootDir);
			currentDir = rootDir;

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String[] inputStr = br.readLine().split(" ");

			while(!inputStr[0].equals("exit")){
				switch(inputStr[0]){
				case "mkdir":
					dirOps.createDir(inputStr[1], currentDir);
					System.out.println("created directory: "+inputStr[1]);
					break;
				case "cd":
					currentDir = dirOps.navigate(inputStr[1], currentDir);
					if(currentDir == null)
						System.out.println("cannot find path specified");
					break;
				case "ls":
					dirOps.listFiles(currentDir);
					break;
				case "pwd":
					System.out.println(dirOps.getFullPath(currentDir));
					break;
				default :
					System.out.println("unknown command!");
					break;
				}
				inputStr = br.readLine().split(" ");
				
					
			}
		}catch(Exception ex){
			ex.printStackTrace();
			System.out.println("Oops! There seems to be a problem. Re-run the system");

		}

	}
}
