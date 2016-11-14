package fr.batiment;

import java.util.ArrayList;
import java.util.List;

public class Ecole extends Batiment {
	private int pEducation;		// equivalent à la capacite de l'ecole
	private static List<Ecole> ecoles = new ArrayList<Ecole>();
	private int indiceEc;
	
		// Constructeurs
	public Ecole (){
		super(40, 10, 3, 1);
		ecoles.add(this);
		this.indiceEc = ecoles.size()-1;
		this.pEducation = 40;
	}
	
	public Ecole (int niv){
		this();
		for (int i=1; i<niv; i++)
			this.ameliore();
	}
	
		// Fonctions individuelles
	public void ameliore (){
		super.ameliore(0.5, 0.2, 3, 2);
		this.pEducation += (int)(this.pEducation*.5);
	}
	public void detruire (){
		super.detruire(this.indice);
		ecoles.remove(this.indiceEc);
		for (int i = this.indiceEc; i < ecoles.size(); i++)
			ecoles.get(i).indiceEc --;
	}
	public void afficheEcole(){		
	System.out.println("nb Salaries : " + this.nbSalarie/10);
	System.out.println("nb Cadres : " + this.nbCadre/10);
	System.out.println("Usure : " + this.risque + "/1000");
	System.out.println("Education : " + this.pEducation);
}
	
	public int education(){
		int e = this.pEducation*this.potentiel()*5/700;		// 5 jours par semaine
		return e;
	}

		// Fonctions communes
	public static int totalEducation(){
		int total = 0;
		for (int i = 0; i<ecoles.size(); i++)
			total += ecoles.get(i).education();
		return total;
	}
}
