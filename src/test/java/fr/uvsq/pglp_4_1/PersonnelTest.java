package fr.uvsq.pglp_4_1;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import fr.uvsq.pglp_4_1.builder.composite.iterator.NumeroTelephone;
import fr.uvsq.pglp_4_1.builder.composite.iterator.Personnel;


public class PersonnelTest {

private Personnel personnel;
	
	@Before()
	public void setUp() {
		 personnel  = new Personnel.PersonnelBuilder("EL KADI", "Kamal", "Etudiant")
				.dateNaissance(LocalDate.parse("1996-01-01", DateTimeFormatter.ISO_DATE))
				.addNumeroTelephone(new NumeroTelephone("Perso", "0666666666")).build();
		
	}
	

	@Test()
	public void testGetNom() {
		assertEquals(personnel.getNom(), "EL KADI");
	}
	
	@Test()
	public void testGetPrenom() {
		assertEquals(personnel.getPrenom(), "Kamal");
	}
	
	@Test()
	public void testGetFonction() {
		assertEquals(personnel.getFonction(), "Etudiant");
	}
	
	@Test()
	public void testGetDateNaissance() {
		assertEquals(personnel.getDateNaissance(), 
				LocalDate.parse("1996-01-01", DateTimeFormatter.ISO_DATE));
	}
	
	@Test()
	public void testGetNumerosTelephone() {
		List<NumeroTelephone> numList = new ArrayList<NumeroTelephone>();
		numList.add(new NumeroTelephone("Perso", "0666666666"));
		assertEquals(personnel.getNumerosTelephone(), numList);	
	}
	
	
	
	

}
