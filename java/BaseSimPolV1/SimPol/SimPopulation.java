import java.lang.Runnable;

public class Population extends Thread {
	private int[][] popTab = new int[130][12];
	private int popBase;
	private int popMax = 1000;
	
	public Population (int a){
		this.popBase = a;
		int i, k, j;
		int col, lig;
		for (j = 0; j < 130; j++)			//Ini
			for (k=0; k < 12; k++)
				popTab[j][k] = 0;
		for (i=a; i>0; i--){
			int random = (int)(Math.random() * 960); // 960 permet de mettre aléatoirement la population dans 12 mois de 80 annees.
			col = random/12;
			lig = random%12;
			//System.out.println("col = " + col + " lig = " + lig);
			this.popTab[col][lig] ++;
		}
	}

	public void run() {
		while ()
	}
	
	public void affichePop (){
		int i, j, nb;
		for (i = 0; i < 130; i++){
			nb=0;
			for (j=0; j < 12; j++)
				nb += this.popTab[i][j];
			System.out.println("Il y a " + nb + " individus de " + i + " an(s)");
		}
	}
	public void affichePop (int min, int max){
		int i, j, nb;
		if (min > max){
			int r = min;
			min = max;
			max = r;
		}			
		if (max > 129){
			max = 129;
			System.out.println("La limite d'age est 129 ans");
		}
		for (i = min; i <= max; i++){
			nb=0;
			for (j=0; j < 12; j++)
				nb += this.popTab[i][j];
			System.out.println("Il y a " + nb + " individus de " + i + " an(s)");
		}
	}
}

/*package tutorialthread.example01;

public class Unthread extends thread{
  public void run() {
    long start = System.currentTimeMillis();
    // boucle tant que la durée de vie du thread est < à 5 secondes
    while( System.currentTimeMillis() < ( start + (1000 * 5))) {
      // traitement
      System.out.println("Ligne affichée par le thread");
      try {
        // pause
        thread.sleep(500);
      }
      catch (InterruptedException ex) {}
    }
  }    
}*/