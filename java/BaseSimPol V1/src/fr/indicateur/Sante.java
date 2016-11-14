package fr.indicateur;

import fr.batiment.Batiment;
import fr.batiment.Hopital;

public class Sante {
	private static int hygiene = 80;	// en % parametre qui influe sur le nombre de malades | influence par les recherches en medecine et par les decrets
	private static int nbMalades;
	private static int nbAccidents;		// accident li�s au risque des batiments
	private static int soins;			// Soins apport� par les hopitaux
	private static int echecs = 5;		// en % tous les soins ne sont pas fructueux, et parfois des gens meurent

	public static void journeeMedicale(){
		tombeMalades();		// On comptabilise les nouveaux malades
		System.out.println(nbMalades + " gens sont malades");
		accidente();			// de meme pour les accidentes
		System.out.println(nbAccidents + " gens ont eu un accident");
		mortalite();			// Parmi ces victimes, certaines ne se reveilleront jamais
		System.out.println(nbMalades+nbAccidents + " ne sont pas encore morts");
		recupSoins();			// Heureusement, les medecins sont la avec leurs competences
		System.out.println(soins + " patients vont �tre secourus");
		apportMedicaux();		// Ces chevaliers de la sante sauvent autant de vies que possible
		System.out.println("il reste " + nbMalades + " malades et " + nbAccidents + " accidentes");
		guerison();				// Et puis, il y a ceux qui se soignent en mangeant bio
		System.out.println(nbMalades+nbAccidents + " patients sont encore dans les hopitaux en fin de soiree");
	}
	
	public static void tombeMalades (){
		int nbSains =  Population.nbIndiv()- nbMalades;
		nbMalades += (int)(Math.random()*(100-hygiene)*nbSains/3000);	// actualisation quotidienne du nombre de malades
	}
	public static void accidente (){
		int nbSaufs = Population.nbIndiv(0, Budget.getAgeRetraite())- nbAccidents;	// Seuls ceux qui se deplacent et ne sont pas deja accidente peuvent subir un accident
		nbAccidents += (int)(Math.random()*Batiment.getTotalRisque()*nbSaufs/1000/30);
	}
	public static void ajoutBlesse(int nb){			// Victimes d'agressions
		nbAccidents += nb;
	}
	public static void mortalite (){
		int mort = (int)(Math.random()*echecs*nbAccidents)/100;		// Tous les accidentes ne survivent pas.
		nbAccidents -= mort;
		Population.retraitPopulation(mort, 0, Budget.getAgeRetraite());
		mort = (int)(Math.random()*echecs*nbMalades)/100;			// Les malades non plus
		Population.retraitPopulation(mort, 0, 129);
		nbMalades -= mort;
	}
	public static void recupSoins (){
		soins = Hopital.soinsTotal();
	}
	
	public static void apportMedicaux(){
		int patients = nbAccidents+nbMalades;
		int ratio = nbMalades*100/patients;		// reparti les efforts medicaux
		if (soins*ratio/100 > nbMalades){
			soins -= nbMalades;
			nbMalades = 0;
		} else {
			nbMalades -= soins*ratio/100;
			soins -= soins*ratio/100;
		}										// L'aide medicale pour les malades a deja ete utilisee, tout le reste est dedie aux accidents
		if (soins > nbAccidents)
			nbAccidents = 0;
		else
			nbAccidents -= soins;
		soins = 0;								// l'aide medicale qui n'a pas ete utilisee est perdue
	}
	
	public static void guerison(){
		nbMalades -= (int)(Math.random()*hygiene*nbMalades/1000);		// parmi les malades entre 0 et 10% guerissent tout seuls en fonctio de l'hygiene
		nbAccidents -= (int)(Math.random()*hygiene*nbAccidents/1000);	// idem pour les maladroits
	}
}
