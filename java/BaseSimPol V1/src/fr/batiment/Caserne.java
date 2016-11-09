package fr.batiment;

import fr.indicateur.Budget;

public class Caserne extends Batiment {
	public int entretien;		// Les pompiers ont la capacite de faire tenir les autres batiments debout

	public Caserne() {
		this.nbSalarie = 60;
		Budget.setNbSalaries(6);
		this.nbCadre = 20;
		Budget.setNbCadre(2);
	}

	public Caserne(int niv) {
		super();
		this.nbSalarie = (int)(60*Math.pow(1.3, niv-1));
		Budget.setNbSalaries((this.nbSalarie)/10);
		this.nbCadre = (int)(20*Math.pow(1.1, niv-1));
		Budget.setNbCadre(this.nbCadre/10);
	}

	
}
