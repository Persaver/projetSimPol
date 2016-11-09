package fr.batiment;

import fr.indicateur.Budget;

public abstract class Stadium extends Batiment {
	public int capacite;		//Elt qui influera sur l'attractivite et la satisfaction du bas peuple
	
	public Stadium() {
		super();
		this.capacite = 15000;
		this.nbSalarie = 40;
		Budget.setNbSalaries(4);
		this.nbCadre = 10;
		Budget.setNbCadre(1);
	}

	public Stadium(int niv) {
		super();
		this.capacite = (int)(15000*Math.pow(1.75, niv-1));
		this.nbSalarie = (int)(40*Math.pow(1.8, niv-1));
		Budget.setNbSalaries(this.nbSalarie/10);
		this.nbCadre = (int)(30*Math.pow(2, niv-1));
		Budget.setNbCadre(this.nbCadre/10);
	}
	public void Ameliore (){
		int newSalarie = (int)(this.nbSalarie*0.75);
		int newCadre = (int)(this.nbCadre*0.8);
		if ((((this.nbCadre + newCadre)/10>(this.nbCadre)/10))){				// Pour garder une coherence dans les chiffres
			Budget.setNbCadre((this.nbCadre+newCadre)/10-this.nbCadre/10);		// Les nouveaux postes de cares sont directement renseigner
		}
		this.nbCadre += newCadre;
		if ((this.nbSalarie + newSalarie)/10>(this.nbSalarie)/10){
			Budget.setNbSalaries((this.nbSalarie+newSalarie)/10-this.nbSalarie/10);
		}
		this.capacite = this.capacite*175/100;
		this.nbSalarie += newSalarie;
	}
	
	public void usure (){		// Regulierement, le batiment s'use
		this.risque +=3;
	}

}
