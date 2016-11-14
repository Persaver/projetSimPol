package fr.batiment;

import java.util.ArrayList;
import java.util.List;

import fr.indicateur.Budget;
import fr.indicateur.Population;


public abstract class Batiment {
	protected int nbCadre;				// Pour leur permettre d'evoluer, les nombres de poste seront multiplies par 10
	protected int nbSalarie;
	protected int risque = 0;			// Risque d'arriv�e d'accidents quotidien (pour 1000)
	protected int modRisque;			// Sans entretien, les risques augmentent
	protected int budgetAlloue;
	protected static List<Batiment> constructions = new ArrayList<Batiment>();
	protected int indice;
	protected int attraction;
	protected int postePourvu;
//	protected int prixBatiment;
	
		// Constructeurs
	public Batiment (){
		constructions.add(this);
		this.indice = constructions.size()-1;
	}
	public Batiment(int baseS, int baseC, int baseR, int att){
		this();
		this.nbSalarie = baseS;
		this.nbCadre = baseC;
		this.modRisque = baseR;
		this.attraction = att;
		this.prisePostes();
	}
	
		// Fonction individuelles}
	public void usure(){
		this.risque += this.modRisque;
	}
	public void modifierRisque(int mod){
		this.risque += mod;
	}
	public void detruire(int indice){
		constructions.remove(indice);	// Supprimer le batiment de la liste
		for (int i = indice; i<constructions.size(); i++)	// actualiser les indices des batiments qui suivent
			constructions.get(i).indice --;
	}
	public void ameliore (double factS, double factC, int modR, int att){
		this.nbSalarie += (int)this.nbSalarie*factS;
		this.nbCadre += (int)this.nbCadre*factC;
		this.modRisque += modR;
		this.attraction += att;
		Population.modAttraction(att);
		this.ajoutPoste();
	}
	public int getNbCadre() {
		return nbCadre/10;
	}
	public int getNbSalarie() {
		return nbSalarie/10;
	}
	public int getRisque(){
		return this.risque;
	}
	public int potentiel(){		// Le budget influe directement sur les capacites du batiment a 30% du budget necessaire le batiment n'a plus de potentiel
		int potentiel =  this.budgetAlloue*100/(this.nbSalarie/10*Budget.getSalaireStandard()+this.nbCadre/10*Budget.getSalaireCadre());
		potentiel = (int)Math.max((potentiel*100-3000)/70., 0.);
		return potentiel;
	}	
	public void setBudget(int x){
		this.budgetAlloue = x;
	}	
	public void setBudget(){
		int salaireUnitaire = (this.nbSalarie/10*Budget.getSalaireStandard()+this.nbCadre/10*Budget.getSalaireCadre())/(this.nbSalarie/10+this.nbCadre/10);
		this.budgetAlloue = salaireUnitaire*this.postePourvu;
	}
	public int getBudget(){
		return this.budgetAlloue;
	}
	public void affichePotentiel(){
		System.out.println(this.potentiel()+"%");
	}
	public int getAttractivite(){
		return this.attraction;
	}
	public int retirerPersonnel(){
		int nbEmploye = this.getNbSalarie()+this.getNbCadre();
		int budgetMax = this.nbSalarie/10*Budget.getSalaireStandard()+this.nbCadre/10*Budget.getSalaireCadre();
		if (budgetAlloue > budgetMax/nbEmploye){
			this.budgetAlloue -= budgetMax/nbEmploye;
			return 1;	// Une personne a bien ete viree
		} else
			return 0;	// Personne n'a ete vire
	}
	public int retirerPersonnel(int n){
		boolean possible = true;
		int verif;
		while (n > 0 && possible){
			verif = this.retirerPersonnel();
			if (verif == 1)
				n--;
			else
				possible = false;
		}
		return n;
	}
	public int getPostePourvu(){
		return this.postePourvu;
	}
	public void prisePostes(){
		int pEmbauche = Population.nbIndiv(Budget.getAgeTravail(), Budget.getAgeRetraite())-getPostesPourvus();
		if (pEmbauche <= 0)
			this.postePourvu = 0;
		else{
			if (pEmbauche > (this.nbSalarie+this.nbCadre)/10)
				this.postePourvu = (this.nbSalarie+this.nbCadre)/10;
			else
				this.postePourvu = pEmbauche;
		}
	}
	public void ajoutPoste(){
		int pEmbauche = Population.nbIndiv(Budget.getAgeTravail(), Budget.getAgeRetraite())-getPostesPourvus();
		if (pEmbauche > (this.nbSalarie+this.nbCadre)/10)
			this.postePourvu = (this.nbSalarie+this.nbCadre)/10;
		else
			this.postePourvu += pEmbauche;
	}
	
		// Fonction communes
	public static void afficheListe(){
		for (int i = 0; i<constructions.size();i++)
			System.out.println(i+1 + " - " +constructions.get(i));
	}
	public static void usures(){			// Fonction quotidienne
		for (int i = 0; i<constructions.size();i++)
			constructions.get(i).usure();
	}
	public static int getNbCadres(){
		int nbC = 0;
		for (int i = 0; i<constructions.size();i++)
			nbC += constructions.get(i).getNbCadre();
		return nbC;
	}
	public static int getNbSalaries(){
		int nbS = 0;
		for (int i = 0; i<constructions.size();i++)
			nbS += constructions.get(i).getNbSalarie();
		return nbS;
	}
	public static int getTotalRisque(){
		int r = 0;
		for (int i = 0; i<constructions.size();i++)
			r += constructions.get(i).getRisque();
		return r;
	}
	public static int getNbActifs(){
		return getNbSalaries()+getNbCadres();
	}
	public static int getAttractivites(){
		int att = 0;
		for (int i = 0; i<constructions.size();i++)
			att += constructions.get(i).getAttractivite();
		return att;
	}
	public static int getBudgets(){
		int b= 0;
		for (int i = 0; i<constructions.size();i++)
			b += constructions.get(i).getBudget();
		return b;
	}
	public static int getPostesPourvus(){
		int p = 0;
		for (int i = 0; i<constructions.size();i++)
			p += constructions.get(i).getPostePourvu();
		return p;
	}
	public static void effectifs(){
		int total = Population.nbIndiv(Budget.getAgeTravail(), Budget.getAgeRetraite());
		int effectif = getPostesPourvus();
		int i = (int)Math.random()*constructions.size();
		while(total < effectif){		// S'il y a plus de postes que d'employes, on supprime des postes pouvus
			effectif -= constructions.get(i).retirerPersonnel();
			i += ((int)Math.random()*10)%constructions.size();
		}
	}
	public static void sabotage(int amplitude){
		int i = (int)Math.random()*constructions.size();
		constructions.get(i).modifierRisque(amplitude);
	}
}
