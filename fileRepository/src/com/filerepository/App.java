package com.filerepository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		String dir = System.getProperty("user.dir");
		Path path = Paths.get(dir + "/" + "MyfileRepo");
		File file = new File(path.toString());
		
		FileRepo.createDirectory(path);

		Scanner sc = new Scanner(System.in);
		System.out.println("==================================================");
		System.out.println("\n\tWelcome to File Repository System!\n");
		System.out.println("\t Developed by: Afreen Fajila\n");
		System.out.println("==================================================");

		while (true) {
			System.out.println("\nSelect one of the choice from below");
			System.out.println("1: Retrieve file list");
			System.out.println("2: Business-level operation");
			System.out.println("3: Exit the program");
			System.out.print("Enter your choice: ");

			String main = sc.nextLine();

			if (main.equals("1")) {
				try {
					
					FileRepo.retrieveFiles(file);
				} catch (IOException e) {
					System.out.println("Unable to retrieve files: " + e.getMessage());
				}
			}

			if (main.equals("2")) {
				System.out.println("\n==================================================");
				System.out.println("You have entered business-level operations");
				System.out.println("==================================================");
				while (main.equals("2")) {
					System.out.println("\nPlease enter one of the following choices as shown below");
					System.out.println("A: Add File");
					System.out.println("B: Delete File");
					System.out.println("C: Search for file");
					System.out.println("D: Go to main menu");
					System.out.print("Enter your choice: ");
					String action = sc.nextLine();
					
					if (action.equalsIgnoreCase("A")) {
						System.out.print("\nEnter file name to add: ");

						String fileName = sc.nextLine();

						File f = new File(path + "/" + fileName);
						
						try {
							FileRepo.addFile(f);
						} catch (IOException e) {
							e.getMessage();
						}
					}
					if (action.equalsIgnoreCase("B")) {
						System.out.print("\nEnter file name to delete: ");

						String fileName = sc.nextLine();

						File f = new File(path + "/" + fileName);
						try {
							FileRepo.deleteFile(f);
						} catch (IOException e) {
							e.getMessage();
						}

					}
					if (action.equalsIgnoreCase("C")) {
						System.out.print("\nEnter file name to search: ");

						String fileName = sc.nextLine();
	
						try {
							FileRepo.searchFile(file, fileName);
						} catch (IOException e) {
							e.getMessage();
						}
					}
					if (action.equalsIgnoreCase("D")) {
						System.out.println("Going to main menu...");
						break;
					}
				}
			}
			if (main.equals("3")) {
				System.out.println("\nProgram have been exited");
				System.exit(0);
			}

		}
	}
}
