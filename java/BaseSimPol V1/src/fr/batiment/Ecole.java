package fr.batiment;

import fr.indicateur.Budget;

public class Ecole extends Batiment {
	private static int education;				// A definir
	
	public Ecole (){
		super();
		this.nbSalarie = 40;
		Budget.setNbSalaries(4);
		this.nbCadre = 10;
		Budget.setNbCadre(1);
	}
	
	public Ecole (int niveau){
		super();
		this.nbSalarie = (int)(40*Math.pow(1.5, niveau-1));
		this.nbCadre = (int)(10*Math.pow(1.2, niveau-1));
		Budget.setNbCadre(this.nbCadre/10);
		Budget.setNbSalaries(this.nbSalarie/10);
	}
	
	public void Ameliore (){
		int newSalarie = (int)(this.nbSalarie*0.5);
		int  newCadre =  (int)(this.nbCadre*0.2);
		if ((((this.nbCadre + newCadre)/10>(this.nbCadre)/10))){				// Pour garder une coherence dans les chiffres
			Budget.setNbCadre((this.nbCadre+newCadre)/10-this.nbCadre/10);		// Les nouveaux postes de cares sont directement renseigner
		}
		this.nbCadre += newCadre;
		if ((this.nbSalarie + newSalarie)/10>(this.nbSalarie)/10){
			Budget.setNbSalaries((this.nbSalarie+newSalarie)/10-this.nbSalarie/10);
		}
		this.nbSalarie += newSalarie;
	}
	
	public void usure (){		// Regulierement, le batiment s'use
		this.risque +=3;
	}
	
	public static int getEducation(){
		return education;
	}
}
