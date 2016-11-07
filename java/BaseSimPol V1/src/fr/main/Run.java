package fr.main;

import fr.batiment.Ecole;
import fr.indicateur.Budget;
import fr.indicateur.Population;

public class Run {

	public static void main(String[] args) {
		int  pop = 20000, nbN, nbM, mois, migre, annee = 0;
		Population p = new Population (pop);
//		System.out.println("[0, 18] " + p.nbIndiv(0, 18) + "\n [19, 62] " + p.nbIndiv(19, 62) + "\n [62, 130]" + p.nbIndiv(62, 129));
		Ecole e = new Ecole();
		e.Ameliore();
		e.Ameliore();
		e.Ameliore();
		e.Ameliore();
		e.Ameliore();
		e.Ameliore();
		e.Ameliore();
		e.Ameliore();
		int eC = e.getNbCadre();
		int eS = e.getNbSalarie();
		System.out.println("nbr ecole : " + eC + " cadres et " + eS + " Salaries");
		System.out.println("nbr gestion : " + Budget.getNbCadre() + " cadres et " + Budget.getNbSalaries() + " Salaries");
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
