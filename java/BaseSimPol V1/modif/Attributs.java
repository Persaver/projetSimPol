package fr;

public class Attributs {
	private int attractivite;
	private int sante;
	private int rentree;		// La somme mensuelle attribuee a notre ville
	private int securite;
	
	
	public void menu(){
		// 1 Budget
		// 2 Securite
		// 3 infra
	}


	public void menuBudget(){
		// 1 modifier les salaire
		// 2 accorder une prime
		// 3 augmenter les impots
	}
	
	public void menuInfra(){
		// 1 construire un batiment
		// 2 ameliorer un batiment
		// 3 detruire un batiment
	}
	
	public void construireBatiment(){
		// 1 ecole
		// 2 commissariat
		// 3 hopital
		// 4 salle de sport
	}
	
	public int migration(){
		return (int)Math.random()*20-10+this.attractivite-100;
	}
	
	
}