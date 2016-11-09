package fr.batiment;

import fr.indicateur.Budget;

public class Banque extends Batiment {

	public Banque() {
		this.nbSalarie = 120;
		Budget.setNbSalaries(12);
		this.nbCadre = 30;
		Budget.setNbCadre(3);
	}

	public Banque(int niv) {
		this.nbSalarie = 70+60*(niv-1);
		Budget.setNbSalaries(this.nbSalarie/10);
		this.nbCadre = (int)(30*Math.pow(1.3, niv-1));
		Budget.setNbCadre(this.nbCadre/10);
	}
	
	public void Ameliore (){
		int newSalarie = 60;
		int newCadre = (int)(this.nbCadre*0.3);
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
	
}
