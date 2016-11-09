package fr.batiment;

import fr.indicateur.Budget;

public class EntrepriseServices extends Batiment {
	private int potentiel;
	private int productivite;

	public EntrepriseServices() {
		this.nbSalarie = 210;
		Budget.setNbSalaries(21);
		this.nbCadre = 30;
		Budget.setNbCadre(3);
	}

	public EntrepriseServices(int niv) {
		super();
		this.nbSalarie = (int)(210*Math.pow(1.8, niv-1));
		Budget.setNbSalaries(this.nbSalarie/10);
		this.nbCadre = nbSalarie/11+1;
		Budget.setNbCadre(this.nbCadre/10);
		this.potentiel = (this.nbSalarie*2000+this.nbCadre*4000);
	}

	public int revenus(){
		int rev = potentiel*productivite/100;
		return rev;
	}
	
	public void usure (){		// Regulierement, le batiment s'use
		this.risque +=4;
	}
	
	public void setProd(){
		this.productivite = Ecole.getEducation()/* *Population.getSatisfaction() * Hopital.getSante /10000 */;
	}
}
