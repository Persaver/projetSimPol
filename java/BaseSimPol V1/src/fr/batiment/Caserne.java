package fr.batiment;

import java.util.ArrayList;
import java.util.List;

import fr.indicateur.Education;

public class Caserne extends Batiment {
	private int pEntretien;		// Potentiel d'entretien des batiments
	private static List<Caserne> casernes = new ArrayList<Caserne>();
	private int indiceCas;

	public Caserne() {
		super(60, 20, 0, 1);
		this.pEntretien = 6;
		this.indiceCas = casernes.size();
		casernes.add(this);
	}

	public Caserne(int niv) {
		this();
		for(int i = 0; i<niv; i++)
			this.ameliorer();
	}
	
	public void ameliorer(){
		this.ameliore(0.3, 0.1, 0, 1);
		this.pEntretien = ((10+this.nbCadre/3)*this.nbSalarie)/50;
	}

	public int getEntretien(){
		return this.pEntretien;
	}
	
		// Les employes vont effectuer des inspection.
	public void entretien(){
		int l = Batiment.constructions.size();
		int e = this.pEntretien*this.potentiel()/100*(300+Education.getEdSecurite())/500;
		int indice = (int)(Math.random()*l);
		while (e>0){		// Si un batiment est bien endommage, les ouvriers vont se concentrer dessus
			if (Batiment.constructions.get(indice).getRisque()>=10){
				if (e>=10){
					Batiment.constructions.get(indice).modifierRisque(10);
					e -= 10;
				} else {
					Batiment.constructions.get(indice).modifierRisque(e);
					e = 0;
				}				// Des qu'ils verront des defauts, les ouvriers vont apporter des reparation
			} else
				if (Batiment.constructions.get(indice).getRisque()>0){
				Batiment.constructions.get(indice).modifierRisque(1); // entre deux batiment, le deplacement leur prend du temps (et ça assure d'arruver a 'e=0'
				e--;
			} // Si tout va bien, on recommence jusqu'a ce qu'il soit l'heure d'arreter
			indice = (indice+1)%l;
			e--;
		}
	}
}