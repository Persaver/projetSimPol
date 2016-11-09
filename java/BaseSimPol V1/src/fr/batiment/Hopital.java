package fr.batiment;

import fr.indicateur.Budget;

public class Hopital extends Batiment {
	private static int sante;						// A definir

	public Hopital() {
		super();
		this.nbSalarie = 70;
		Budget.setNbSalaries(7);
		this.nbCadre = 10;
		Budget.setNbCadre(1);
	}

	public Hopital(int niv) {
		super();
		this.nbSalarie = (int)(70*Math.pow(1.8, niv-1));
		Budget.setNbSalaries(this.nbSalarie/10);
		this.nbCadre = (int)(10*Math.pow(1.8, niv-1));
		Budget.setNbCadre(this.nbCadre/10);
	}
	
	public void Ameliore (){
		int newSalarie = (int)(this.nbSalarie*0.8);
		int newCadre = (int)(this.nbCadre*0.8);
		if ((((this.nbCadre + newCadre)/10>(this.nbCadre)/10))){				// Pour garder une coherence dans les chiffres
			Budget.setNbCadre((this.nbCadre+newCadre)/10-this.nbCadre/10);		// Les nouveaux postes de cares sont directement renseigner
	//		System.out.println("nbCadres + " + newCadre/10);
		}
		this.nbCadre += newCadre;
		if ((this.nbSalarie + newSalarie)/10>(this.nbSalarie)/10){
			Budget.setNbSalaries((this.nbSalarie+newSalarie)/10-this.nbSalarie/10);
	//		System.out.println("nbPoste + " + (newSalarie)/10);
		}
		this.nbSalarie += newSalarie;
	}
	
	public void usure (){		// Regulierement, le batiment s'use
		this.risque +=2;
	}

	public static int getSante(){
		return sante;
	}
}
