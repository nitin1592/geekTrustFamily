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
}
