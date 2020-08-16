package com.family.geekTrustFamily;

import static com.family.geekTrustFamily.Constants.Message.INVALID_COMMAND;
import static com.family.geekTrustFamily.Constants.Operation.ADD_CHILD;
import static com.family.geekTrustFamily.Constants.Operation.ADD_FAMILY_HEAD;
import static com.family.geekTrustFamily.Constants.Operation.ADD_SPOUSE;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileProcessor {
	
	public void processInputFile(File file, FamilyTree familyTree, boolean isInitialFile) {
		
		try {
			Scanner sc = new Scanner(file);
			while (sc.hasNext()) {
				String line = sc.next();
				
				if (isInitialFile)
					processInitialInput(familyTree, line);
				else
					processInput(familyTree, line);
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
	}
	
	private void processInitialInput(FamilyTree familyTree, String line) {
		String[] arr = line.split(",");
		
		switch (arr[0]) {
		case ADD_FAMILY_HEAD:
			
			break;
		
		case ADD_CHILD:
			
			break;
		
		case ADD_SPOUSE:
			
			break;

		default:
			System.out.println(INVALID_COMMAND);
			break;
		}
	}
	
	private void processInput(FamilyTree familyTree, String line) {
		
	}

}
