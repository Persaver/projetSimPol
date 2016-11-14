package fr.main;

import fr.batiment.Batiment;
import fr.batiment.Commissariat;
import fr.indicateur.Budget;
import fr.indicateur.Criminalite;
import fr.indicateur.Education;
import fr.indicateur.Population;
import fr.indicateur.Sante;

public class Temporalite {
	public void jourZero(){		// Apres que le site ait ete initialise, il jourZero met tous les parametres a jours
		Education.recupEducation();
		Education.distibution();
	}
	public void jounee(){
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
	public void mois(){
		Population.vieillissementM();
		Budget.payeEployes();
	}
	
	public void afficheSituation(){
		System.out.println("il y a " + Population.nbIndiv() + " citoyens\n"
				+ "");
	}
}
