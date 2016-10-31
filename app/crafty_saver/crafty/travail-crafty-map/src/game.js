Game = {
	// varibale pour tester sans serveur
	ISDEBUG : true,
	// enembles des données du jeu a sauvegarder
	gameDatas :{
		// ensembles des objets sur la carte
		mapObjects : {}	
	},
 
	
	// This defines our grid's size and the size of each of its tiles
 	map_grid: {
	 	width:  40,
	 	height: 40,
		tile: {
			width:  16,
			height: 16
		}
	},
 
  // The total width of the game screen. Since our grid takes up the entire screen
  //  this is just the width of a tile times the width of the grid
  width: function() {
    return this.map_grid.width * this.map_grid.tile.width;
  },
 
  // The total height of the game screen. Since our grid takes up the entire screen
  //  this is just the height of a tile times the height of the grid
  height: function() {
    return this.map_grid.height * this.map_grid.tile.height;
  },
 
  // Initialize and start our game
  start: function() {
    // Start crafty and set a background color so that we can see it's working
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
