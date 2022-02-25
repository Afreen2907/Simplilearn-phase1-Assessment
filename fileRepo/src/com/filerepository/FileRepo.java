package com.filerepository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class FileRepo {
	
	public static void createDirectory(Path filePath) {

			if(!Files.exists(filePath)) {
				try {
					Files.createDirectories(filePath);
				} catch (IOException e) {
					System.out.println("Unable to create directory..." + e.getMessage());
				}
				
			} 
		
	}

	public static void retrieveFiles(File file) throws IOException {
		System.out.println("\nRetrieving list of files...");
		
		String[] fileList = file.list();
		Arrays.sort(fileList);
		if (fileList.length == 0) {
			System.out.println("There are no files in this folder");
		} else {
			for (String str : fileList) {
				System.out.println(str);
			}
		}
	}
	
	public static void deleteFile(File file) throws IOException {
		if (file.delete()) {
			System.out.println(file.getName() + " deleted");
		} else {
			System.out.println("Unable to delete file " + "'" + file.getName() + "'");
		}
	}
	
	public static void addFile(File file) throws IOException {
		if (file.createNewFile()) {
			System.out.println("File" + "'" + file.getName() + "'" + "has been created.");
		} else {
			System.out.println("File" + "'" + file.getName() + "'" + "already exists.");
		}
	}
	
	public static void searchFile(String fileList[], String fileName)    throws IOException {
		if(fileList.length == 0) {
			System.out.println("The folder is empty");
		} else {
			for (int i = 0; i<fileList.length; i++) {
				if(fileList[i].equals(fileName)) {
					System.out.println("File " + "'" + fileName + "'" + " is found");
					break;
				} else {
					System.out.println("File not found");
				}
			}
		}
	}

}
