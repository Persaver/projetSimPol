package fr.batiment;

public class Mairie extends Batiment {
		// La mairie est un batiment qui est present des le debut, (qui peut evoluer?) et qui ne sera pas present dans les constructions proposees
	public Mairie() {
		super(70, 10, 1, 5);
	}
	public Mairie(int niv) {
		this();
		for (int i = 0; i<niv; i++)
			this.ameliorer();
	}
	public void ameliorer(){
		super.ameliore(0.8, 0.8, 1, 3);
	}
}
