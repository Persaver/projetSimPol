package fr.batiment;

import java.util.ArrayList;
import java.util.List;

import fr.indicateur.Budget;

public abstract class Batiment {
	protected int nbCadre;				// Pour leur permettre d'evoluer, les nombres de poste seront multiplies par 10
	protected int nbSalarie;
	protected int risque = 0;
	protected static List<Batiment>construction = new ArrayList<Batiment>(); 
	
	public Batiment (){
		construction.add(this);
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
	
	public static void afficheList(){
		for (int i = 0; i < construction.size(); i++){
			System.out.println(construction.get(i));
		}
	}
	
	public static int getNbSalaries(){
		int nb = 0;
		for (int i = 0; i < construction.size(); i++){
			nb += construction.get(i).getNbSalarie();
		}
		return nb;
	}
}
