package fr.batiment;

public abstract class Stadium extends Batiment {
	public int capacite;		//Elt qui influera sur l'attractivite et la satisfaction du bas peuple
	
	public Stadium() {
		super();
		this.nbSalarie = 40;
		this.nbCadre = 10;
		this.capacite = 15000;
		this.modRisque = 3;
	}

	public Stadium(int niv) {
		super();
		this.nbSalarie = (int)(40*Math.pow(1.8, niv-1));
		this.nbCadre = (int)(30*Math.pow(2, niv-1));
		this.capacite = (int)(15000*Math.pow(1.75, niv-1));
		this.modRisque = 3*niv;
	}
	public void Ameliore (){
		this.nbSalarie += (int)(this.nbSalarie*0.75);
		this.nbCadre += (int)(this.nbCadre*0.8);
		this.capacite = this.capacite*175/100;
		this.modRisque += 3;
	}
}
