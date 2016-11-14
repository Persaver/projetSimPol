package fr.batiment;

public class EntrepriseServices extends Batiment {
	private int potentiel;
	private int productivite;

	public EntrepriseServices() {
		this.nbSalarie = 210;
		this.nbCadre = 30;
		this.modRisque = 4;
	}

	public EntrepriseServices(int niv) {
		super();
		this.nbSalarie = (int)(210*Math.pow(1.8, niv-1));
		this.nbCadre = nbSalarie/11+1;
		this.potentiel = (this.nbSalarie*2000+this.nbCadre*4000);
		this.modRisque = 4*niv;
	}
	
	public void Ameliore (){
		this.nbSalarie += (int)(this.nbSalarie*0.8);
		this.nbCadre = this.nbSalarie/11+1;
		this.modRisque += 4;
	}

	public int revenus(){
		int rev = potentiel*productivite/100;
		return rev;
	}
}
