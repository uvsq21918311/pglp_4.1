package fr.uvsq.pglp_4_1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import fr.uvsq.pglp_4_1.builder.composite.iterator.NumeroTelephone;
import fr.uvsq.pglp_4_1.builder.composite.iterator.ParGroupeIterator;
import fr.uvsq.pglp_4_1.builder.composite.iterator.ParHierarchieIterator;
import fr.uvsq.pglp_4_1.builder.composite.iterator.Personnel;
import fr.uvsq.pglp_4_1.builder.composite.iterator.Personnel.PersonnelBuilder;
import fr.uvsq.pglp_4_1.builder.composite.iterator.PersonnelGroupe;
import fr.uvsq.pglp_4_1.builder.composite.iterator.PersonnelType;
import fr.uvsq.pglp_4_1.builder.composite.iterator.PersonnelTypeIterator;



public enum AnnuairePersonnels {
	ENVIRONNEMENT;
	

	private PersonnelGroupe init() {
		PersonnelBuilder pb = new PersonnelBuilder("Kamal", "EL KADI", "Etudiant")
				.dateNaissance(LocalDate.parse("1996-01-01", DateTimeFormatter.ISO_DATE))
				.addNumeroTelephone(new NumeroTelephone("Perso", "0666666666"))
				.addNumeroTelephone(new NumeroTelephone("Fax", "0612345678"));
		Personnel pers1 = pb.build(), pers2 = pb.build();
		Personnel pers3 = pb.build(), pers4 = pb.build();
		PersonnelGroupe pg1 = new PersonnelGroupe();
		PersonnelGroupe pg2 = new PersonnelGroupe();
		PersonnelGroupe pg3 = new PersonnelGroupe();
		pg1.addPersonnel(pers1);
		pg1.addPersonnel(pers3);
		pg2.addPersonnel(pers2);
		pg3.addPersonnel(pers4);
		pg1.addPersonnel(pg2);
		pg2.addPersonnel(pg3);
		System.out.println(pers1);
		return pg1;
	}
	
	private void afficherParcours(PersonnelTypeIterator pti) {
		System.out.println("-" + pti.getRacine().typeString());
		while (pti.hasNext()) {
			PersonnelType personnelType = (PersonnelType) pti.next();
			System.out.println("-" + personnelType.typeString());
		}
	}
	
	private void run(String[] args) {
		PersonnelGroupe pg = init();	
		
		System.out.println("== Profondeur ==");
		afficherParcours(new ParHierarchieIterator(pg));
		
		System.out.println("== Largeur ==");
		afficherParcours(new ParGroupeIterator(pg));		
	}
	
	public static void main(String[] args) {
		ENVIRONNEMENT.run(args);
	}
	
}
