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
    	String initialFile = "";
    	String inputFile = "";
    	
    	try {
			solution.initiateFileProcesser(familyTree, initialFile, true);
			solution.initiateFileProcesser(familyTree, inputFile, false);
		} catch (Exception e) {
			System.out.println("Error in arguements");
			e.printStackTrace();
		}
    }
}
