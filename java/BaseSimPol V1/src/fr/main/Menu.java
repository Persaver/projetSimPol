package fr.main;

public class Menu {
	public void afficherMenuPrincipal(){
		System.out.println("1-  jouer\n"
				+ "2 - Quitter");
	}
	public void afficherMenuJeu(){
		System.out.println("1 - Afficher l'etat de la population\n"
				+ "2 - Passer au jour suivant\n"
				+ "3 - Ajouter un batiment\n"
				+ "4 - Modifier un batiment\n"
				+ "4 - Detruire un batiment\n"
				+ "5 - Modifier un parametre\n");
	}
	public void afficherMenuParametre(){
		System.out.println("1 - Budget\n"
				+ "2 - Parametre superieur\n");
	}
	public void afficherConstructionBatiment(){
		System.out.println("1 - Commissariat\n"
				+ "2 - Ecole\n"
				+ "3 - Hopital\n");
	}
	public void afficherModifierBatiment(){
		System.out.println("1 - Ameliorer\n"
				+ "2 - Modifier le Budget\n"
				+ "3 - Virer Employe(s)\n"
				+ "4 - Embaucher\n");
	}
	public void afficherMenuBudget(){
		System.out.println("1- Modifier l'age d'embauche"
				+ "2 - Modifier l'age de retraite"
				+ "3 - Modifier le salaire des ouvriers"
				+ "4 - Modifier le salaire des cadres"
				+ "5 - Modifier les charges salariales"
				+ "6 - Modifier les charges des cadres");
	}
}
