package fr.batiment;

public abstract class Stadium extends Batiment {
	public int capacite;		//Elt qui influera sur l'attractivite et la satisfaction du bas peuple
	
	public Stadium() {
		super(40, 10, 3, 5);
	}

	public Stadium(int niv) {
		this();
		for (int i = 0; i< niv; i++)
			this.ameliore();
	}
	public void ameliore (){
		super.ameliore(0.75, 0.8, 3, 6);
		this.capacite = this.capacite*175/100;
	}
}
