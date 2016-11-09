package fr.main;

import java.util.ArrayList;
import java.util.List;

import fr.batiment.Banque;
import fr.batiment.Batiment;
import fr.batiment.Commissariat;
import fr.batiment.Ecole;
import fr.batiment.EntrepriseServices;
import fr.batiment.Mairie;
import fr.indicateur.Budget;
import fr.indicateur.Population;

public class Run {

	public static void main(String[] args) {
		List<Batiment>construction = new ArrayList<Batiment>();
		Mairie m = new Mairie();
		construction.add(m);
		Ecole e = new Ecole();
		construction.add(e);
		Commissariat c = new Commissariat();
		construction.add(c);
		Banque b = new Banque();
		construction.add(b);
		EntrepriseServices es = new EntrepriseServices();
		construction.add(es);
		int eC = e.getNbCadre();
		int eS = e.getNbSalarie();
		System.out.println("nbr ecole : " + eC + " cadres et " + eS + " Salaries");
		System.out.println("nbr gestion : " + Budget.getNbCadre() + " cadres et " + Budget.getNbSalaries() + " Salaries");
		Batiment.afficheList();
		System.out.println(m.getNbSalarie());
		System.out.println(m.getNbSalaries());
		
//		p.affichePop(0, 80);
/*		while (p.nbIndiv(0, 129) > 20){
			nbN = 0; nbM = 0; migre = 0;
			int nbNt = 0;
			for (mois = 0; mois < 12; mois ++){
				nbNt = p.vieillissementM();
				nbN += nbNt;
				nbM += pop-(p.nbIndiv(0, 129)-nbNt);
				nbNt = 0;
				migre += p.flux((int)(Math.random()*10)-4);
				pop = p.nbIndiv(0, 129);
				//System.out.println("mois " + mois + ", population actuelle : " + pop);
				//System.out.println(+ nbN + " naissances, " + nbM + " morts et " + migre + " migrants");
			}
//			try{
//				Thread.sleep(100);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			System.out.println("annee " + annee + ", population actuelle : " + pop);
			System.out.println(+ nbN + " naissances, " + nbM + " morts et " + migre + " migrants");
			annee ++;
		}*/
//		System.out.println("derniere annee " + annee + ", population actuelle : " + pop);
	}
}
