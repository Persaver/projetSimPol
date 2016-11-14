package fr.main;

import fr.batiment.Batiment;
import fr.batiment.Caserne;
import fr.batiment.Commissariat;
import fr.batiment.Ecole;
import fr.batiment.Hopital;
import fr.indicateur.Budget;
import fr.indicateur.Criminalite;
import fr.indicateur.Education;
import fr.indicateur.Population;
import fr.indicateur.Sante;

public class Temporalite {
	public void initialisation(){
		Population p = new Population(200);
		
		Commissariat c1 = new Commissariat();
		Ecole e1 = new Ecole();
		Caserne ca1 = new Caserne();
		Hopital h1 = new Hopital();
	}
	
	public void jourZero(){		// Apres que le site ait ete initialise, il jourZero met tous les parametres a jours
		Education.recupEducation();
		Education.distibution();
	}
	public static void journee(){
		Sante.tombeMalades();
		Sante.accidente();
		Criminalite.crime();
		Sante.mortalite();
		Batiment.effectifs();
		Batiment.usures();
		Commissariat.allSecure();
		Sante.recupSoins();
		Population.flux(Population.migration());
		Sante.apportMedicaux();
		Sante.guerison();
	}
	public static void mois(){
		Population.vieillissementM();
		Budget.payeEployes();
	}
	
	public void afficheSituation(){
		System.out.println("il y a " + Population.nbIndiv() + " citoyens\n"
				+ "");
	}
}
