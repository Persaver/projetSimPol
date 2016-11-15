package fr.main;

import java.util.Scanner;

import fr.batiment.Banque;
import fr.batiment.Batiment;
import fr.batiment.Caserne;
import fr.batiment.Commissariat;
import fr.batiment.Ecole;
import fr.batiment.EntrepriseServices;
import fr.batiment.Hopital;
import fr.batiment.Stadium;
import fr.indicateur.Budget;
import fr.indicateur.Criminalite;
import fr.indicateur.Education;
import fr.indicateur.Population;
import fr.indicateur.Sante;

public class Menu {
	public void afficherMenuPrincipal(){
		System.out.println("1-  jouer\n"
				+ "2 - Quitter");
	}
	public void afficherMenuJeu(){
		System.out.println("1 - Afficher l'etat du jeu\n"
				+ "2 - Passer au jour suivant\n"
				+ "3 - Ajouter un batiment\n"
				+ "4 - Modifier un batiment\n"
				+ "5 - Detruire un batiment\n"
				+ "6 - Modifier un parametre\n"
				+ "7 - Quitter");
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
		System.out.println("1- Modifier l'age d'embauche\n"
				+ "2 - Modifier l'age de retraite\n"
				+ "3 - Modifier le salaire des ouvriers\n"
				+ "4 - Modifier le salaire des cadres\n"
				+ "5 - Modifier les charges salariales\n"
				+ "6 - Modifier les charges des cadres");
	}
	
	public void choixPrincipal(){
		Scanner scan = new Scanner(System.in);
		afficherMenuPrincipal();
		int choix = scan.nextInt();
		switch (choix){
		case 1 :
			choixJeu();
			break;
		case 2 :
			System.out.println("Merci d'etre passe");
			scan.close();
			break;
		}
	}
	public void choixJeu(){
		Scanner scan = new Scanner(System.in);
		afficherMenuJeu();
		int choix = scan.nextInt();
		switch (choix){
		case 1:
			afficherEtatJeu();
			choixJeu();
			break;
		case 2:
			Temporalite.journee();
			choixJeu();
			break;
		case 3:
			ajoutBatiment();
			choixJeu();
			break;
		case 4:
			Batiment.afficheListe();
			modifierBatiment();
			choixJeu();
			break;
		case 5:
			Batiment.afficheListe();
			SupprimerBatiment();
			choixJeu();
			break;
		case 6:
			ModifierParametre();
			choixJeu();
			break;
		case 7:
			System.out.println("Merci d'avoir joue");
			break;
		}
	}
	public void afficherEtatJeu(){
		System.out.println("Population totale : " + Population.nbIndiv() + "\n"
				+"Population ouvriere : " + Population.nbIndiv(Budget.getAgeTravail(), Budget.getAgeRetraite()) + " pour " + Batiment.getNbActifs() + " postes\n");
		Education.afficher();
		Criminalite.afficheCrime();
		System.out.println("Efficacite des forces de l'ordre : " + Commissariat.Efficacites());
		System.out.println("Victimes d'accidents / agressions : " + Sante.getNbAccidents());
		System.out.println("Malades : " + Sante.getNbMalades());
		System.out.println("Capacite de soin des hopitaux : " + Hopital.soinsTotal());
	}
	public void afficherTypeBatiment(){
		System.out.println("1 - Commissariat\n"
				+ "2 - Ecole\n"
				+ "3 - Hopital\n"
				+ "4 - Caserne\n"
				+ "5 - Banque\n"
				+ "6 - Entreprise\n"
				+ "7 - Stadium");
	}
	public void ajoutBatiment(){
		Scanner scan = new Scanner (System.in);
		afficherTypeBatiment();
		int choix = scan.nextInt();
		switch (choix){
		case 1:
			new Commissariat();
			break;
		case 2:
			new Ecole();
			break;
		case 3:
			new Hopital();
			break;
		case 4:
			new Caserne();
			break;
		case 5:
			new Banque();
			break;
		case 6:
			new EntrepriseServices();
			break;
		case 7:
			new Stadium();
			break;
		}
	}
}
