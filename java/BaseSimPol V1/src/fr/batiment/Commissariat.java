package fr.batiment;

import fr.indicateur.Budget;
import fr.indicateur.Criminalite;

public class Commissariat extends Batiment{
	private static int influence;				// A definir
	
	public Commissariat (){
		super();
		this.nbSalarie = 60;
		Budget.setNbSalaries(6);
		this.nbCadre = 20;
		Budget.setNbCadre(2);
	}
	
	public Commissariat (int niv){
		super();
		this.nbSalarie = (int)(60*Math.pow(1.4, niv-1));
		Budget.setNbSalaries((this.nbSalarie)/10);
		this.nbCadre = (int)(20*Math.pow(1.2, niv-1));
		Budget.setNbCadre(this.nbCadre/10);
	}
	
	public void Ameliore (){
		int newSalarie = (int)(this.nbSalarie*0.5);
		int  newCadre =  (int)(this.nbCadre*0.2);
		if ((this.nbSalarie + newSalarie)/10>(this.nbSalarie)/10){
			Budget.setNbSalaries((this.nbSalarie+newSalarie)/10-this.nbSalarie/10);
		}
		this.nbSalarie += newSalarie;
		int modif = nbSalarie/6;												// Nb Cadres en fonction du nombre de salaries
		if (((modif/10>(this.nbCadre)/10))){									// Pour garder une coherence dans les chiffres
			Budget.setNbCadre((modif)/10-this.nbCadre/10);						// Les nouveaux postes de cares sont directement renseigner
		}
		this.nbCadre += newCadre;
	}
	
	public void usure (){		// Regulierement, le batiment s'use
		this.risque +=1;
	}
	
	public static void secure(){
		Criminalite.cumulMineur(-influence);
	}
}
