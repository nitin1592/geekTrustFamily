package com.family.geekTrustFamily;

import java.util.ArrayList;
import java.util.List;
import static com.family.geekTrustFamily.Constants.Message.*;
import static com.family.geekTrustFamily.Constants.Relationship.*;

public class FamilyTree {
	private FamilyMember familyHead;
	
	public String getRelations(String memberName, String relation) {
		String result = "";
		
		FamilyMember member = searchMember(familyHead, memberName);
		if (member == null)
			result = PERSON_NOT_FOUND;
		else
			result = getAllRelations(member, relation);
		return result;
	}
	
	public String getAllRelations(FamilyMember member, String relation) {
		String result = "";
		
		switch (relation) {
			case PATERNAL_UNCLE:
				if (member.mother != null)
					result = member.mother.spouse.searchSiblings(Gender.MALE);
				break;
			case MATERNAL_UNCLE:
				if (member.mother != null)
					result = member.mother.searchSiblings(Gender.MALE);
				break;
			case PATERNAL_AUNT:
				if (member.mother != null)
					result = member.mother.spouse.searchSiblings(Gender.FEMALE);
				break;
			case MATERNAL_AUNT:
				if (member.mother != null)
					result = member.mother.searchSiblings(Gender.FEMALE);
				break;
			case SISTER_IN_LAW:
				result = searchInLaws(member, Gender.FEMALE);
				break;
			case BROTHER_IN_LAW:
				result = searchInLaws(member, Gender.MALE);
				break;
			case SON :
				result = member.findChildren(Gender.MALE);
				break;
			case DAUGHTER :
				result = member.findChildren(Gender.FEMALE);
				break;
			case SIBLINGS:
				if (member.mother != null) {
					result = member.searchSiblings(Gender.FEMALE);
					if (result.length() > 0)
						result += " ";
					result += member.searchSiblings(Gender.MALE);
				}
				break;
			default:
				result = PROVIDE_VALID_RELATION;
		}
		
		return ("".equals(result)) ? NONE : result;
	}
	
	public String searchInLaws (FamilyMember member, Gender gender) {
		StringBuffer result = new StringBuffer();
		if (member.spouse != null)
			result.append(member.spouse.searchSiblings(gender));
		
		if (member.mother != null) {
			Gender targetGender = (gender==Gender.FEMALE) ? Gender.MALE : Gender.FEMALE;
			ArrayList<FamilyMember> list = member.mother.findChildrenList(targetGender);
			
			for (FamilyMember fm : list) {
				if ((!fm.name.equals(member.name)) && fm.spouse!=null)
					result.append(fm.spouse.name).append(" ");
			}
		}
		return result.toString().trim();
	}
	
	public void addFamilyHead(String name, Gender gender) {
		this.familyHead = new FamilyMember(name, null, null, gender);
	}
	
	public void addSpouse(String memberName, String spouseName, String gender) {
		FamilyMember member = searchMember(familyHead, memberName);
		if (member!=null && member.spouse==null) {
			Gender gen = (gender.equals("FEMALE")) ? Gender.FEMALE : Gender.MALE;
			FamilyMember newMember = new FamilyMember(spouseName, null, member, gen);
			member.spouse = newMember;
		}
	}
	
	public String addChild(String motherName, String childName, String gender) {
		FamilyMember member = searchMember(familyHead, motherName);
		if (member == null)
			return PERSON_NOT_FOUND;
		else if (childName==null || gender==null)
			return CHILD_ADDITION_FAILED;
		else if (member.gender==Gender.FEMALE && member.spouse!=null){
			Gender g = gender.equals("FEMALE") ? Gender.FEMALE : Gender.MALE;
			member.children.add(new FamilyMember(childName, member, null, g));
			return CHILD_ADDITION_SUCCEEDED;
		}
		else
			return CHILD_ADDITION_FAILED;
	}
	
	public FamilyMember searchMember(FamilyMember head, String memberName) {
		if (memberName==null || head==null)
			return null;
		
		FamilyMember member = null;
		
		if (head.name.equals(memberName))
			return head;
		else if (head.spouse!=null && head.spouse.name.equals(memberName))
			return head.spouse;
		
		List<FamilyMember> children = new ArrayList<FamilyMember>();
		
		if (head.gender == Gender.FEMALE)
			children = head.children;
		else if (head.spouse != null)
			children = head.spouse.children;
		
		for (FamilyMember child : children) {
			member = searchMember(child, memberName);
			if (member != null)
				break;
		}
		return member;
	}
}