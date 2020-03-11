package fr.uvsq.pglp_4_1.builder.composite.iterator;

import java.util.Stack;

public class ParHierarchieIterator extends PersonnelTypeIterator {
	
	public ParHierarchieIterator(PersonnelGroupe personnelGroupe) {
		super(personnelGroupe, new Stack<PersonnelType>());
	}

	@Override
	protected PersonnelType getFromCollection() {
		return ((Stack<PersonnelType>) collection).pop();
	}

}
