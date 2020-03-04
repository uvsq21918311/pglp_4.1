package fr.uvsq.pglp_4_1.builder.composite.iterator;

import java.util.ArrayList;

public class CompositePersonnel implements InterfacePersonnel{

	private int id;
	private ArrayList<InterfacePersonnel> personnels ;
	

	public CompositePersonnel(int id) {
		this.id = id;
		personnels= new ArrayList<InterfacePersonnel>();
	}
	
	public void add(InterfacePersonnel personnel) {
		personnels.add(personnel);
	}
	
	
	public void remove(InterfacePersonnel personnel) {
		personnels.remove(personnel);
	}


	public void print() {
		
		
	}

}
