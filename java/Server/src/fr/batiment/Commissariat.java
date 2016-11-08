package fr.batiment;

import fr.indicateur.Budget;

public class Commissariat extends Batiment{
	private int nbPrimes;
	
	public Commissariat (){
		this.nbSalarie = 60;
		this.nbCadre = 20;
		Budget.setNbCadre(2);
		Budget.setNbSalaries(8);
	}
	
	public Commissariat (int niveau){
		this.nbSalarie = (int)(60*Math.pow(1.4, niveau-1));
		this.nbCadre = (int)(20*Math.pow(1.2, niveau-1));
		Budget.setNbCadre(this.nbCadre/10);
		Budget.setNbSalaries((this.nbSalarie+this.nbCadre)/10);
	}
}
