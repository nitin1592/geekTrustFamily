package com.family.geekTrustFamily;

import static com.family.geekTrustFamily.Constants.Message.INVALID_COMMAND;
import static com.family.geekTrustFamily.Constants.Operation.ADD_CHILD;
import static com.family.geekTrustFamily.Constants.Operation.ADD_FAMILY_HEAD;
import static com.family.geekTrustFamily.Constants.Operation.ADD_SPOUSE;
import static com.family.geekTrustFamily.Constants.Operation.GET_RELATIONSHIP;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileProcessor {
	
	public void processInputFile(File file, FamilyTree familyTree, boolean isInitialFile) {
		Scanner sc = null;
		try {
			sc = new Scanner(file);
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				
				if (isInitialFile)
					processInitialInput(familyTree, line);
				else
					processInput(familyTree, line);
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
		finally {
			sc.close();
		}
	}
	
	private void processInitialInput(FamilyTree familyTree, String line) {
		String[] arr = line.split(",");

		switch (arr[0]) {
			case ADD_FAMILY_HEAD:
				familyTree.addFamilyHead(arr[1], Gender.FEMALE);
				break;
			
			case ADD_CHILD:
				familyTree.addChild(arr[1], arr[2], arr[3]);
				break;
			
			case ADD_SPOUSE:
				familyTree.addSpouse(arr[1], arr[2], arr[3]);
				break;
	
			default:
				System.out.println(INVALID_COMMAND);
				break;
		}
	}
	
	private void processInput(FamilyTree familyTree, String line) {
		String[] arr = line.split(" ");
		String result = "";
		
		switch (arr[0]) {
			case ADD_CHILD:
				result = familyTree.addChild(arr[1], arr[2], arr[3]);
				break;
			case GET_RELATIONSHIP:
				result = familyTree.getRelations(arr[1], arr[2]);
				break;
			default:
				result = INVALID_COMMAND;
		}
		System.out.println(result);
	}

}
