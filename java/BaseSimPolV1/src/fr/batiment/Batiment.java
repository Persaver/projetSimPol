package fr.batiment;

import fr.indicateur.Budget;

public abstract class Batiment {
	protected int nbCadre;				// Pour leur permettre d'evoluer, les nombres de poste seront multiplies par 10
	protected int nbSalarie;
//	protected int prixBatiment;
//	private int nbHautDiplome;
//	private int nbSpecialiste;
	
	
	public Batiment (){
	}
	
	public Batiment (int niv){
	}
	
	public int coutPers(){
		int p = this.nbCadre*Budget.getSalaireCadre()+
				this.nbSalarie*Budget.getSalaireStandard()/*+
				this.nbHautDiplome*Budget.getSalaireHautDiplome()+
				this.nbSpecialiste*Budget.getSalaireSpecialiste()*/;
		return p;	
	}
	
	public void detruire(){
	}
	public void ameliorer(){
	}
	public int getNbCadre() {
		return nbCadre/10;
	}
	public int getNbSalarie() {
		return nbSalarie/10;
	}
}
