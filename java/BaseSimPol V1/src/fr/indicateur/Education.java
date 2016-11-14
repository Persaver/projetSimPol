package fr.indicateur;

import fr.batiment.Ecole;

public abstract class Education {
	private static int edTotale;		// L'Education apportee par les ecoles
	private static int edSecurite;		// L'education distribuee aux commissariats
	private static int edEntretien;		// L'education distribuee aux casernes
	private static int edSante;			// L'education distribuee aux hopitaux
	private static int edRecherche;		// L'education distribuee aux recherches
	private static int edTourisme;		// L'education distribuee aux batiment touristiques
	
	public static void recupEducation(){
		int place = Ecole.totalEducation();
		int etudiant = Population.nbIndiv(0, Budget.getAgeTravail());
		if (place-etudiant < 0)		// S'il n'y a pas assez de place pour les etudiant, l'education en pati
			edTotale = (place*500/etudiant)*((int)(Math.sqrt((double)Budget.getAgeTravail())/4));		// varie aussi selon l'age estime de fin d'etude. a 16 ans, facteur de 1, � 25 ans, facteur de 1.25, 36 ans, facteur de 1.5 ...
		else {						// S'il y a plus de place, alors, les cours du soir et les formation d'ouvrier peuvent augmenter la productivite
			edTotale = ((100+(place-etudiant)/4)*5)*((int)(Math.sqrt((double)Budget.getAgeTravail())/4));
		}
		
	}
	
	public static void distibution (){
		edSecurite = edTotale%5 > 0 ? edTotale/5+1 : edTotale/5;
		edEntretien = edTotale%5 > 1 ? edTotale/5+1 : edTotale/5;
		edSante= edTotale%5 > 2 ? edTotale/5+1 : edTotale/5;
		edRecherche = edTotale%5 > 3 ? edTotale/5+1 : edTotale/5;
		edTourisme = edTotale%5 > 4 ? edTotale/5+1 : edTotale/5;
	}
	
	public static void monterSecurite (int mod){
		int possible = 4;					// S'il n'est plus possible de prendre des points d'education dans les autres secteurs, on arrete
		while (mod > 0 && possible > 0){	
			if (edEntretien > 0 && mod > 0){		// On verifie pour chaque domaine si on peut prendre des points d'education
				edEntretien --;
				edSecurite ++;
				mod --;
			} else
				possible --;
			if (edSante > 0 && mod > 0){
				edSante --;
				edSecurite ++;
				mod --;
			} else
				possible --;
			if (edRecherche > 0 && mod > 0){
				edRecherche --;
				edSecurite ++;
				mod --;
			} else
				possible --;
			if (edTourisme > 0 && mod > 0){
				edTourisme --;
				edSecurite ++;
				mod --;
			} else
				possible --;
			
		}
	}
	public static void descendreSecurite (int mod){
		if (mod > edSecurite)
			mod = edSecurite;
		edSecurite -= mod;
		edEntretien += mod/4;
		edSante += mod/4;
		edRecherche += mod/4;
		edTourisme += mod/4;
		mod = mod%4;
		if (mod > 0){
			edEntretien ++;
			mod --;
		}
		if (mod > 0){
			edSante ++;
			mod --;
		}
		if (mod > 0){
			edRecherche ++;
			mod --;
		}
		if (mod > 0)
			edTourisme ++;
	}		
	public static void modifierSecurite (int mod){
		if (mod > 0)
			monterSecurite(mod);
		else
			descendreSecurite(-mod);
	}
	public static void monterEntretien (int mod){
		int possible = 4;					// S'il n'est plus possible de prendre des points d'education dans les autres secteurs, on arrete
		while (mod > 0 && possible > 0){	
			if (edSante > 0 && mod > 0){		// On verifie pour chaque domaine si on peut prendre des points d'education
				edSante --;
				edEntretien ++;
				mod --;
			} else
				possible --;
			if (edRecherche > 0 && mod > 0){
				edRecherche --;
				edEntretien ++;
				mod --;
			} else
				possible --;
			if (edTourisme > 0 && mod > 0){
				edTourisme --;
				edEntretien ++;
				mod --;
			} else
				possible --;
			if (edSecurite > 0 && mod > 0){
				edSecurite --;
				edEntretien ++;
				mod --;
			} else
				possible --;
			
		}
	}
	public static void descendreEntretien (int mod){
		if (mod > edEntretien)
			mod = edEntretien;
		edEntretien -= mod;
		edSante += mod/4;
		edRecherche += mod/4;
		edTourisme += mod/4;
		edSecurite += mod/4;
		mod = mod%4;
		if (mod > 0){
			edSante ++;
			mod --;
		}
		if (mod > 0){
			edRecherche ++;
			mod --;
		}
		if (mod > 0){
			edTourisme ++;
			mod --;
		}
		if (mod > 0){
			edSecurite ++;
			mod --;
		}
	}
	public static void modifierEntretien (int mod){
		if (mod > 0)
			monterEntretien(mod);
		else
			descendreEntretien(-mod);
	}
	public static void monterSante (int mod){
		int possible = 4;					// S'il n'est plus possible de prendre des points d'education dans les autres secteurs, on arrete
		while (mod > 0 && possible > 0){
			if (edRecherche > 0 && mod > 0){
				edRecherche --;
				edSante ++;
				mod --;
			} else
				possible --;
			if (edTourisme > 0 && mod > 0){
				edTourisme --;
				edSante ++;
				mod --;
			} else
				possible --;
			if (edSecurite > 0 && mod > 0){
				edSecurite --;
				edSante ++;
				mod --;
			} else
				possible --;
			if (edEntretien > 0 && mod > 0){
				edEntretien --;
				edSante ++;
				mod --;
			} else
				possible --;
		}
	}
	public static void descendreSante (int mod){
		if (mod > edSante)
			mod = edSante;
		edSante -= mod;
		edRecherche += mod/4;
		edTourisme += mod/4;
		edSecurite += mod/4;
		edEntretien += mod/4;
		mod = mod%4;
		if (mod > 0){
			edRecherche ++;
			mod --;
		}
		if (mod > 0){
			edTourisme ++;
			mod --;
		}
		if (mod > 0){
			edSecurite ++;
			mod --;
		}
		if (mod > 0){
			edEntretien ++;
			mod --;
		}
	}
	public static void modifierSante (int mod){
		if(mod > 0)
			monterSante(mod);
		else
			descendreSante(-mod);
	}
	public static void monterRecherche (int mod){
		int possible = 4;					// S'il n'est plus possible de prendre des points d'education dans les autres secteurs, on arrete
		while (mod > 0 && possible > 0){
			if (edTourisme > 0 && mod > 0){
				edTourisme --;
				edRecherche ++;
				mod --;
			} else
				possible --;
			if (edSecurite > 0 && mod > 0){
				edSecurite --;
				edRecherche ++;
				mod --;
			} else
				possible --;
			if (edEntretien > 0 && mod > 0){
				edEntretien --;
				edRecherche ++;
				mod --;
			} else
				possible --;
			if (edSante > 0 && mod > 0){
				edSante --;
				edRecherche ++;
				mod --;
			} else
				possible --;
		}
	}
	public static void descendreRecherche (int mod){
		if (mod > edRecherche)
			mod = edRecherche;
		edRecherche -= mod;
		edTourisme += mod/4;
		edSecurite += mod/4;
		edEntretien += mod/4;
		edSante += mod/4;
		mod = mod%4;
		if (mod > 0){
			edTourisme ++;
			mod --;
		}
		if (mod > 0){
			edSecurite ++;
			mod --;
		}
		if (mod > 0){
			edEntretien ++;
			mod --;
		}
		if (mod > 0){
			edSante ++;
			mod --;
		}
	}
	public static void modifierRecherche (int mod){
		if(mod > 0)
			monterRecherche(mod);
		else
			descendreRecherche(-mod);
	}
	public static void monterTourisme (int mod){
		int possible = 4;					// S'il n'est plus possible de prendre des points d'education dans les autres secteurs, on arrete
		while (mod > 0 && possible > 0){
			if (edSecurite > 0 && mod > 0){
				edSecurite --;
				edTourisme ++;
				mod --;
			} else
				possible --;
			if (edEntretien > 0 && mod > 0){
				edEntretien --;
				edTourisme ++;
				mod --;
			} else
				possible --;
			if (edSante > 0 && mod > 0){
				edSante --;
				edTourisme ++;
				mod --;
			} else
				possible --;
			if (edRecherche > 0 && mod > 0){
				edRecherche --;
				edTourisme ++;
				mod --;
			} else
				possible --;
		}
	}
	public static void descendreTourisme (int mod){
		if (mod > edTourisme)
			mod = edTourisme;
		edTourisme -= mod;
		edSecurite += mod/4;
		edEntretien += mod/4;
		edSante += mod/4;
		edRecherche += mod/4;
		mod = mod%4;
		if (mod > 0){
			edSecurite ++;
			mod --;
		}
		if (mod > 0){
			edEntretien ++;
			mod --;
		}
		if (mod > 0){
			edSante ++;
			mod --;
		}
		if (mod > 0){
			edRecherche ++;
			mod --;
		}
	}
	public static void modifierTourisme (int mod){
		if(mod > 0)
			monterTourisme(mod);
		else
			descendreTourisme(-mod);
	}

	public static void setEdTotale(int tot){
		edTotale = tot;
	}
	public static void afficher(){
		System.out.println("Total = " + edTotale);
		System.out.println("Securite = " + edSecurite);
		System.out.println("Entretien = " + edEntretien);
		System.out.println("Sante = " + edSante);
		System.out.println("Recherche = " +edRecherche);
		System.out.println("Tourisme = " + edTourisme);
		
	}

	public static int getEdSecurite() {
		return edSecurite;
	}

	public static void setEdSecurite(int edSecurite) {
		Education.edSecurite = edSecurite;
	}

	public static int getEdEntretien() {
		return edEntretien;
	}

	public static void setEdEntretien(int edEntretien) {
		Education.edEntretien = edEntretien;
	}

	public static int getEdSante() {
		return edSante;
	}

	public static void setEdSante(int edSante) {
		Education.edSante = edSante;
	}

	public static int getEdRecherche() {
		return edRecherche;
	}

	public static void setEdRecherche(int edRecherche) {
		Education.edRecherche = edRecherche;
	}

	public static int getEdTourisme() {
		return edTourisme;
	}

	public static void setEdTourisme(int edTourisme) {
		Education.edTourisme = edTourisme;
	}

	public static int getEdTotale() {
		return edTotale;
	}
}
