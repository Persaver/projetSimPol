package fr.indicateur;

import fr.batiment.Batiment;

public class Criminalite {
	private static int indicMineur;
	private static int crimeMineur;
	private static int indicMoyen;
	private static int crimeMoyen;
	private static int indicGrave;
	private static int crimeGrave;
	private static int indicTerrorisme;
	private static int crimeTerroriste;
	
	// Une fonction pour calculer la valeur quotidienne du crime mineur
	public static void actuIndicMin(){
		indicMineur = (int)((9*Budget.pauvrete()/*+insatisfaction(p)*/)*15*Math.sqrt((double)Population.nbIndiv())/3000);
	}	
	public static void cumulMineur(int modif){
		crimeMineur += modif;
		if (crimeMineur < 0)
			crimeMineur = 0;
	}
	
	// Une fonction pour calculer la valeur quotidienne du crime moyen
	public static void actuIndicMo(){
		indicMoyen = (int)((6.5*Budget.pauvrete()/*+3.5*insatisfaction(p)*/)*10*Math.sqrt((double)Population.nbIndiv())/3000);
	}	
	public static void cumulMoyen(int modif){
		crimeMoyen += modif;
		if (crimeMoyen < 0)
			crimeMoyen = 0;
	}
	
	// Une fonction pour calculer la valeur quotidienne du crime grave
	public static void actuIndicG(){
		indicGrave = (int)((3.5*Budget.pauvrete()/*+6.5*insatisfaction(p)*/)*5*Math.sqrt((double)Population.nbIndiv())/3000);
	}	
	public static void cumulGrave(int modif){
		crimeGrave += modif;
		if (crimeGrave < 0)
			crimeGrave = 0;
	}
	
	// Une fonction pour calculer la valeur quotidienne du terrorisme
	public static void actuIndicT(){
		indicTerrorisme = (int)((Budget.pauvrete()/*+9*insatisfaction(p)*/)*Math.sqrt((double)Population.nbIndiv(0, 129))/3000);
	}	
	public static void cumulTerreur(int modif){
		crimeTerroriste += modif;
		if (crimeTerroriste < 0)
			crimeTerroriste = 0;
	}
	
	public static void crime (){
		actuIndicMin();
		cumulMineur(indicMineur);
		Budget.modifierCaisse(-(int)Math.random()*crimeMineur*4/5*20);		// 80% des crimes mineurs cherchent a voler une somme de 20
		Sante.ajoutBlesse((int)Math.random()*crimeMineur*3/10);				// 30% des crimes mineurs peuvent engendrer des blesses
		actuIndicMo();
		cumulMoyen(indicMoyen);
		Budget.modifierCaisse(-(int)Math.random()*crimeMoyen*7/10*50);		// 70% des crimes moyens cherchent a voler une somme de 20
		Sante.ajoutBlesse((int)Math.random()*crimeMoyen*4/10);				// 40% des crimes moyens peuvent engendrer des blesses
		actuIndicG();
		cumulGrave(indicGrave);
		Budget.modifierCaisse(-(int)Math.random()*crimeMineur*3/5*200);		// 60% des crimes graves cherchent a voler une somme de 20
		Sante.ajoutBlesse((int)Math.random()*crimeMineur/2);				// 50% des crimes graves peuvent engendrer des blesses
		actuIndicT();
		cumulTerreur(indicTerrorisme);
		while (crimeTerroriste > 40){
			Batiment.sabotage((int)Math.random()*120);						// Le terroriste s'attaquera a des infrastructures 
			Sante.ajoutBlesse((int)Math.random()*Population.nbIndiv()/20);	// Plus la population sera nombreuse, plus il sera facile de faire beaucoup de victimes
			crimeTerroriste -= 40;
		}
	}

	public static void afficheCrime(){
		System.out.println("Crime Mineur : " + crimeMineur);
		System.out.println("Crime Moyen : " + crimeMoyen);
		System.out.println("Crime Grave : " + crimeGrave);
		System.out.println("Crime Terroriste : " + crimeTerroriste);
	}
	public static int getIndicMineur() {
		return indicMineur;
	}
	public static void setIndicMineur(int iMin) {
		indicMineur = iMin;
	}
	public static int getCrimeMineur() {
		return crimeMineur;
	}
	public static void setCrimeMineur(int crimeMin) {
		crimeMineur = crimeMin;
	}
	public static int getIndicMoyen() {
		return indicMoyen;
	}
	public static void setIndicMoyen(int iMo) {
		indicMoyen = iMo;
	}
	public static int getCrimeMoyen() {
		return crimeMoyen;
	}
	public static void setCrimeMoyen(int crimeMo) {
		crimeMoyen = crimeMo;
	}
	public static int getIndicGrave() {
		return indicGrave;
	}
	public static void setIndicGrave(int iG) {
		indicGrave = iG;
	}
	public static int getCrimeGrave() {
		return crimeGrave;
	}
	public static void setCrimeGrave(int crimeG) {
		crimeGrave = crimeG;
	}
	public static int getIndicTerrorisme() {
		return indicTerrorisme;
	}
	public static void setIndicTerrorisme(int iT) {
		indicTerrorisme = iT;
	}
	public static int getCrimeTerroriste() {
		return crimeTerroriste;
	}
	public static void setCrimeTerroriste(int crimeT) {
		crimeTerroriste = crimeT;
	}
}
