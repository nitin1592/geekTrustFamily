package com.family.geekTrustFamily;

import java.util.ArrayList;

enum Gender {
	MALE, FEMALE;
}

public class FamilyMember {
	String name;
	FamilyMember mother;
	FamilyMember spouse;
	Gender gender;
	ArrayList<FamilyMember> children;
	public FamilyMember(String name, FamilyMember mother, FamilyMember spouse, Gender gender) {
		this.name = name;
		this.mother = mother;
		this.spouse = spouse;
		this.gender = gender;
		this.children = new ArrayList<FamilyMember>();
	}
	
	
	
	public String searchSiblings(Gender gender) {
		StringBuffer result = new StringBuffer();
		
		if (this.mother != null) {
			for (FamilyMember sibling : this.mother.children) {
				if ((!sibling.name.equals(this.name)) && sibling.gender==gender)	
					result.append(sibling.name).append(" ");
			}
		}
		
		return result.toString().trim();
	}
	
	public String findChildren(Gender gender) {
		StringBuffer result = new StringBuffer();
		
		if (this.spouse != null) {
			ArrayList<FamilyMember> list = (this.gender==Gender.FEMALE) ? this.children : this.spouse.children;
			
			for (FamilyMember member : list)
				result.append(member.name).append(" ");
		}
		
		return result.toString().trim();
	}
	
	public ArrayList<FamilyMember> findChildrenList(Gender gender) {
		ArrayList<FamilyMember> result = new ArrayList();
		for (FamilyMember child : this.children) {
			if (child.gender == gender)
				result.add(child);
		}
		return result;
	}
	
//	public String findAllChildren(FamilyMember member) {
//		StringBuffer result = new StringBuffer();
//		
//		for (FamilyMember child : this.children) {
//			if (!(child.name.equals(member.name)))
//				result.append(child.name).append(" ");
//		}
//		
//		return result.toString().trim();
//	}
}
