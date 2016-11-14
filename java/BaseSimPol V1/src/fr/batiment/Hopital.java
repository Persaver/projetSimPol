package fr.batiment;

import java.util.ArrayList;
import java.util.List;

import fr.indicateur.Education;

public class Hopital extends Batiment {
	private int pSoin;	// potentiel de soins prodigues par l'hopital
	private static List<Hopital> hopitaux = new ArrayList<Hopital>();
	private int indiceH;
	
	public Hopital (){
		super(70, 10, 3, 2);
		this.indiceH = hopitaux.size();
		hopitaux.add(this);
		this.pSoin = this.nbSalarie*(10+this.nbCadre/5)/100;
	}
	public Hopital (int niv){
		this();
		for (int i = 0; i<niv; i++)
			this.ameliorer();
	}
	
	public void ameliorer(){
		super.ameliore(0.8, 0.8, 3, 2);
		this.pSoin = this.nbSalarie*(10+this.nbCadre/5)/100;
	}
	
	public void detruire (){
		super.detruire(this.indice);
		hopitaux.remove(this.indiceH);
		for (int i = this.indiceH; i < hopitaux.size(); i++)
			hopitaux.get(i).indiceH --;
	}
	
	public int soins (){
		return this.pSoin*this.potentiel()/100*(300+Education.getEdSante())/500;	// N'est qu'a 60% si l'education est nulle
	}
	
	public static int soinsTotal(){
		int sT = 0;
		for (int i = 0; i<hopitaux.size(); i++)
			sT += hopitaux.get(i).soins();
		return sT;
			
	}
}
