package fr.batiment;

import java.util.ArrayList;
import java.util.List;

import fr.indicateur.Budget;
import fr.indicateur.Population;

public abstract class Batiment {
	protected int nbCadre;				// Pour leur permettre d'evoluer, les nombres de poste seront multiplies par 10
	protected int nbSalarie;
	protected int modRisque;
	protected int risque = 0;
	protected static List<Batiment>construction = new ArrayList<Batiment>(); 
	
	public Batiment (){
		construction.add(this);
	}
	
	public Batiment (int niv){
	}

	
	public void detruire(){
	}
	public void ameliorer(){
	}

	
		// Fonction individuelles
	public int getNbCadre() {
		return nbCadre/10;
	}
	public int getNbSalarie() {
		return nbSalarie/10;
	}
	public int getRisque(){
		return this.risque;
	}
	public void modRisque(int mod){
		this.risque -= mod;
	}
	public int coutPers(){
		int p = this.nbCadre*Budget.getSalaireCadre()+
				this.nbSalarie*Budget.getSalaireStandard();
		return p;
	}	
	public void usure (){			// Regulierement, le batiment s'use
		this.risque += this.modRisque;
	}
	
		// Fonctions Communes
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
	public static int getNbCadres(){
		int nb = 0;
		for (int i = 0; i < construction.size(); i++){
			nb += construction.get(i).getNbCadre();
		}
		return nb;
	}
	public static int getTotalRisque(){
		int r = 0;
		for (int i = 0; i < construction.size(); i++){
			r += construction.get(i).getRisque();
		}
		return r;
	}
	public static void usures(){	// fonction qui fait s'user tous les batiments chaque jour
		for (int i = 0; i < construction.size(); i++){
			construction.get(i).usure();
		}
	}
	public static void afficheEtat(){
		for (int i = 0; i < construction.size(); i++){
			System.out.println("Batiment de type " +construction.get(i).getClass() + " avec un risque d'accident de " + construction.get(i).getRisque() + "%");
		}
	}
	public static int necessiteux (Population p){		// par jour?
		int accident = (getTotalRisque()*p.nbIndiv(3, Budget.getAgeRetraite())/100)/construction.size();
		int malades = p.nbIndiv(0, 129)/* *(100-Hygiene)*/ /85;
		int necessiteux = accident + malades;
		return necessiteux;
	}
}