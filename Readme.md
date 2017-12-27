In-memory filesystem
--------------------------
This project is a basic simulation for in-memory file system using Java and Data structures.

#Directory data-structure:
 
 Used doubly linked list to navigate thru the filesystem. Segregated directories, files using hashmap to improve "find" complexity. 

	private String name;
	private Directory parentDir;
	private Map<String, Directory> childDirs = new HashMap<>();
	private Map<String, File> files = new HashMap<>();

#File data-structure:

Used Object to support any file type.

	private String name;
	private Object data;
	
#FileOperations -interface:

Contains basic operations to create file. Added a default method clone to exactly create a copy of given file.
Created a file factory to have definitions w.r.t file extension. Eg: TextFileCreator, JsonFileCreator 

	default public void clone(String name, File from){
		//TODO implement method to create a clone of from "file" 
	}
	
#Sample-Output:<br>
By default system assumes current directory as root with 1.txt and 2.txt files.<br>
Run PalyFileSystem as Java Application.

Instructions console output: 
----------------------------
commands:<br>
 mkdir <dirname><br>
 cd <path><br>
 ls<br>
 pwd<br>
 exit<br>
Please enter any of the above listed commands to get the feel of unix file system.<br>

    pwd
    path: root/

    ls
    2.txt
    1.txt

    mkdir harikishore
    created directory: harikishore

    pwd
    root/

    cd harikishore

    pwd
    root/harikishore/

    mkdir alca
    created directory: alca

    cd alca

    pwd
    root/harikishore/alca/

    cd ..

    pwd
    root/harikishore/

