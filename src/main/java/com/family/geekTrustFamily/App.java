package com.family.geekTrustFamily;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Solution solution = new Solution();
    	FamilyTree familyTree = new FamilyTree();
    	String initialFile = "/Users/nitinbansal/eclipse-workspace/geekTrustFamily/src/main/java/com/family/geekTrustFamily/initInput.txt";
    	String inputFile = "/Users/nitinbansal/eclipse-workspace/geekTrustFamily/src/main/java/com/family/geekTrustFamily/inputFile.txt";
    	
    	try {
			solution.initiateFileProcesser(familyTree, initialFile, true);
			solution.initiateFileProcesser(familyTree, inputFile, false);
		} catch (Exception e) {
			System.out.println("Error in arguements");
			e.printStackTrace();
		}
    }
}
