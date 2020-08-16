package com.family.geekTrustFamily;

import java.io.File;

public class Solution {
	
	public void initiateFileProcesser(FamilyTree familyTree, String fileName, boolean isInitialFile) {
		File file = new File(fileName);
		FileProcessor fileProcessor = new FileProcessor();
		fileProcessor.processInputFile(file, familyTree, isInitialFile);
	}
}
