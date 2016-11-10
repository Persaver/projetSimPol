package fr.batiment;

public class Banque extends Batiment {

	public Banque() {
		this.nbSalarie = 120;
		this.nbCadre = 30;
		this.modRisque = 3;
	}

	public Banque(int niv) {
		this.nbSalarie = 70+60*(niv-1);
		this.nbCadre = (int)(30*Math.pow(1.3, niv-1));
		this.modRisque = 3*niv;
	}
	
	public void Ameliore (){
		this.nbSalarie += 60;
		this.nbCadre += (int)(this.nbCadre*0.3);
		this.modRisque += 3;
	}
	
}
