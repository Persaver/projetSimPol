Game = {
	// variable pour tester sans serveur
	ISDEBUG : true,
	// enembles des données du jeu a sauvegarder
	gameDatas :{
		// ensembles des objets sur la carte
		mapObjects : {}
	},


	//On définit ici la taille de la grille en unité tuile
 	map_grid: {
	 	width:  40,
	 	height: 40,
		//On définit ici en Px la taille d'une tuile
		tile: {
			width:  16,
			height: 16
		}
	},

  //La longueur de la grille est ici calculée
  width: function() {
    return this.map_grid.width * this.map_grid.tile.width;
  },

  //la hauteur de la grille est ici calculée
  height: function() {
    return this.map_grid.height * this.map_grid.tile.height;
  },

  //On initialise et lance le jeu
  start: function() {
    //On initialise la première fenêtre sa taille et son background.
		//Attention, selon la documention, il est necessaire de passer une fonction
		//en plus du nom de la scène
    Crafty.init(Game.width(), Game.height());
    Crafty.background('rgb(249, 223, 125)');
    Crafty.scene('Loading');
	// on recupere les données

  },
  // recuperation des données
  // si ISDEBUG on prend les données du data.json
  // params Le nom des objets à recuperer si vide revoye tt les infos

	getData:function(){
		var data = {};
		if(this.ISDEBUG){
			var dataJson = spl_debugJson;
			for (key in dataJson){
				this.gameDatas[key] = dataJson[key];
			}
		}
		else{
			// ici on fera l'appel a Ajax pour recuperer depuis le serveur
		}


	}
}
