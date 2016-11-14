package fr.batiment;

public class Mairie extends Batiment {
		// La mairie est un batiment qui est present des le debut, (qui peut evoluer?) et qui ne sera pas present dans les constructions proposees
	public Mairie() {
		super();
		this.nbSalarie = 70;
		this.nbCadre = 10;
	}

	public Mairie(int niv) {
		super();
		this.nbSalarie = (int)(70*Math.pow(1.8, niv-1));
		this.nbCadre = (int)(10*Math.pow(1.8, niv-1));
	}

}
