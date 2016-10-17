package fr.population;

public class Population extends Thread {
	private int[][] popTab = new int[130][12];
	private int fertilite = 29;		// fertilite x 10 pour rester en int
	
// Entree	: nombre total de la population
// Fonction : reparti aleatoirement la population dans les differentes tranches d'age
// Remarque : Version basique a detailler
// Verifiee : oui
	public Population (int a){
		int i;
		int col, lig;
		for (i=a; i>0; i--){
			int random = (int)(Math.random() * 960); // 960 permet de mettre al�atoirement la population dans 12 mois de 80 annees.
			col = random/12;
			lig = random%12;
			//System.out.println("col = " + col + " lig = " + lig);
			this.popTab[col][lig] ++;
		}
	}
	
// Entree	: le nombre d'individus a evaluer. L'age des sujets
// Fonction	: determine le nombre de personnes qui ne survivront pas
// Remarque	: 1 Les variables devront pouvoir etre influencee par differents facteurs (hygiene, avancee biologique, etc...)
//			  2 Formule basique, a voir pour la rendre plus precise (actuellement, 24 personnes arrivent a 130 ans sur une population de 10M)
//			  3 Le nombre de mort comprends une legere variable aleatoire pour eviter le systematisme
//			  4 La valeur rendue est a l'echelle annuelle, calculs a reverifier pour des tranches de temps plus courte
//	  		  5 - La fonction renvoie un entier, utile pour le developpement, possibilite de ne rien renvoyer
//	  		  6 - La fonction est public, peut-etre la rendre private
// Verifiee	: Oui
	public int morts(int nbIndiv, int age){
		int nbMort;
		if (age < 3){
			nbMort = (age-3)*(age-3);
		} else {
			if (age < 10)
				return 0;
			else
				nbMort = (age-10)*(age-10)/400;
		}
		System.out.println("1 - nbMort = " + nbMort);
		nbMort -= nbMort*((int)(Math.random()*100)-50)/100;
		System.out.println("2 - nbMort = " + nbMort);
		if (nbMort < 0 || nbMort > nbIndiv){
			return 0;
		}
		return nbMort;
	}

// Entree	: / - La fonction regroupe toutes les naissances de la population et les regroupe dans la case des nouveaux nes
// Fonction : Definit le nombre de naissance en fonction du nombre de personne en age de reproduction de la cite et du taux de fertilite
// Remarque : 1 - Le taux de fertilite est multiple par 10 pour rester en INT
//			  2 - La fonction calcul les naissances mensuelle, peut facilement calculer pour differentes echelles de temps
//			  3 - La fonction renvoie un entier, utile pour le developpement, possibilite de ne rien renvoyer
//			  4 - La fonction est public, peut-etre la rendre private
// Verifiee :
	public int naissances (){
		int x, y, n = 0;
		int num = nbIndiv(17, 42) * this.fertilite;
		int denom = 2*12*25*10;							// Nb indiviu par couple * nb mois * nb annee * equilibrateur fertilite
		while (num > denom){
			num -= denom;
			n++;
		}
		x = (int) (Math.random()*num);
		y = (int) (Math.random()*denom);
		if (x > y){
			n++;
		}
		return n;
	}

// Entree	: les ages limitant de la tranche d'age desiree
// Fonction : Renvoie le nombre d'individu de la tranche d'age demandee
// Remarque :
// Verifiee : Oui
	public int nbIndiv (int min, int max){
		int i, j, nb = 0;
		for (i = min; i <= max; i++){
			for (j=0; j < 12; j++)
				nb += this.popTab[i][j];
		}
		return nb;
	}

// Entree	: / Agit directement sur toute la population
// Fonction	: Effectue les differentes operations de naissance, de mort et de vieillissement de la population (fait appel aux fonctions 'naissance' et 'mort'
// Remarque	: Fonction centrale de l'evolution de la population.
// Verifiee	: Oui
	public int vieillissementM (){
		int i, j, nbN;
		nbN = this.naissances();
		for (i = 129; i >= 0; i--){
			for (j = 11; j >= 0; j--){
				if (i == 0 && j == 0){
					this.popTab[i][j] = nbN;
				} else {
					if (j == 0){
						this.popTab[i][j] = this.popTab[i-1][11]-morts(this.popTab[i-1][11], i);//vieillissement
					} else {
						this.popTab[i][j] = this.popTab[i][j-1]-morts(this.popTab[i-1][11], i); //vieillissement
					}
				}
			}
		}
		return nbN;
	}

// Entree	: /
// Fonction : Affiche tout le tableau
// Remarque : L'affichage se fait a l'echelle annuelle
// Verifiee : Oui
	public void affichePop (){
		int i, j, nb;
		for (i = 0; i < 130; i++){
			nb=0;
			for (j=0; j < 12; j++)
				nb += this.popTab[i][j];
			System.out.println("Il y a " + nb + " individus de " + i + " an(s)");
		}
	}
	
// Entree 	: Les limitants de la tranche d'age desiree
// Fonction	: Affiche la tranche d'age souhaitee
// Remarque	: L'affichage se fait a l'echelle annuelle
// Verifiee	: Oui
	public void affichePop (int min, int max){
		int i, j, nb;
		if (min > max){
			int r = min;
			min = max;
			max = r;
		}			
		if (max > 129){
			max = 129;
			System.out.println("La limite d'age est 129 ans");
		}
		for (i = min; i <= max; i++){
			nb=0;
			for (j=0; j < 12; j++)
				nb += this.popTab[i][j];
			System.out.println("Il y a " + nb + " individus de " + i + " an(s)");
		}
	}
}

// A venir : l'utilisation des Thread (sleep, essentiellement) pour lancer une simulation a partir de quelques parametres initiaux. 
