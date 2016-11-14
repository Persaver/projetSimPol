package fr.indicateur;

import fr.batiment.Batiment;
import fr.batiment.Commissariat;

public class Budget {
	private static int CaissePubliqe;
	private static int ageTravail = 19;				// L'age � partir duquel les citoyens travaillent 
	private static int ageRetraite = 62;			// Age de la retraite
	private static int chargeSalariale = 20;		// En pourcentage
	private static int chargeCadre = 40;
	private static int salaireStandard = 1250;
	private static int salaireCadre = 2350;
	
	public static int pauvrete(){
		int a = Population.nbIndiv(ageTravail, ageRetraite);			// On r�cup�re tous les citoyens en age de travailler
		double postEfficience = Math.min((double)(Batiment.getNbCadres() + Batiment.getNbSalaries())/a, (double)a/(Batiment.getNbCadres() + Batiment.getNbSalaries()));			// On compare ce nombre au nombre de postes de la ville 
		int ratio = Batiment.getNbSalaries()*100/a;			// On note le ratio Ouvrier / Cadres
		double pauvreteO = Math.min((double)(salaireStandard*(100-chargeSalariale)/100-300)/6, 100.)*postEfficience;	// en dessous de 900, la pauvrete s'installe. a 300, elle est au maximum
		double pauvreteC = Math.min((double)(salaireCadre*(100-chargeCadre)/100-300)/6, 100.)*postEfficience;
		int pauvrete = (int)(pauvreteO*ratio+pauvreteC*(100-ratio))/100;		// On reunifie les chiffres des cadres et ceux des ouvriers, le r�sultat sera en %
		return 100-pauvrete;
	}
	
	public static void recettePolices(){
		CaissePubliqe += Commissariat.leveRecettes();
	}
	public static void payeEployes(){
		CaissePubliqe -= Batiment.getBudgets();
	}
	
	public static void modifierCaisse(int mod){
		CaissePubliqe += mod;
	}
	public static int getAgeTravail() {
		return ageTravail;
	}
	public static void setAgeTravail(int ageT) {
		ageTravail = ageT;
	}
	public static int getAgeRetraite() {
		return ageRetraite;
	}
	public static void setAgeRetraite(int ageR) {
		ageRetraite = ageR;
	}
	public static int getChargeSalariale() {
		return chargeSalariale;
	}
	public static void setChargeSalariale(int chS) {
		chargeSalariale = chS;
	}
	public static int getChargeCadre() {
		return chargeCadre;
	}
	public static void setChargeCadre(int chC) {
		chargeCadre = chC;
	}
	public static int getSalaireStandard() {
		return salaireStandard;
	}
	public static void setSalaireStandard(int salaireS) {
		salaireStandard = salaireS;
	}
	public static int getSalaireCadre() {
		return salaireCadre;
	}
	public static void setSalaireCadre(int salaireC) {
		salaireCadre = salaireC;
	}
	public static int getCaissePubliqe() {
		return CaissePubliqe;
	}
	public static void setCaissePubliqe(int caissePubliqe) {
		CaissePubliqe = caissePubliqe;
	}
}
