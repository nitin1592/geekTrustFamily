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
	
	public String searchAuntsAndUncles(Gender gender) {
		StringBuffer result = new StringBuffer();
		
		
		
		return result.toString().trim();
	}
	
	public String findChildren(Gender gender) {
		StringBuffer result = new StringBuffer();
		
		for (FamilyMember child : this.children) {
			if (child.gender == gender)
				result.append(child.name).append(" ");
		}
		
		return result.toString().trim();
	}
	
	public String findAllChildren(FamilyMember member) {
		StringBuffer result = new StringBuffer();
		
		for (FamilyMember child : this.children) {
			if (!(child.name.equals(member.name)))
				result.append(child.name).append(" ");
		}
		
		return result.toString().trim();
	}
}
