Crafty.scene('Town', function(){
	// varibale pour tester sans serveur
	var ISDEBUG = true;


	// A 2D array to keep track of all occupied tiles
	this.occupied = [Game.map_grid.width];
	// initialise la grille a false partout
	for (var i = 0; i < Game.map_grid.width; i++) {
		this.occupied[i] = [Game.map_grid.height];
		for (var y = 0; y < Game.map_grid.height; y++) {
			this.occupied[i][y] = false;
		}
	}
	// test si une case est occupée 
	// params x,y coord ; facultatif w,h nombre de case a tester =>  this.isOccupied(15,15) == this.isOccupied(15,15,1,1) 
	// return true si une case au moins est occupé

	this.isOccupied = function(x, y, w, h){
		if( h === undefined && w == undefined){
			return this.occupied[x][y];
		} else{
			var isOccupied = false;
			var i=0,j;
			while (!isOccupied && i < h && ((x+i) < this.occupied.length )){
				j=0;
				while ( !isOccupied && j < w && ((y+j) < this.occupied[i].length) ){
					isOccupied |= this.occupied[x+i][y+j];
					console.log(this.occupied[x+i][y+j]);
					j++;
				}
				i++;
			}
			return !!isOccupied;		
		}
	}
	
	// passe a occupé les cases concernées
	// params x,y les coord de la tuile Facultatif w,h nombre de case en largeur et hauteur
	this.setOccupied = function(x, y, w, h){
		if( h === undefined && w == undefined){
			this.occupied[x][y] = true;
		} else{
			var i=0,j;
			while (!isOccupied && i < h && ((x+i) < this.occupied.length )){
				j=0;
				while ( !isOccupied && j < w && ((y+j) < this.occupied[i].length) ){
					this.occupied[x+i][y+j] = true;
					console.log(this.occupied[x+i][y+j]);
					j++;
				}
				i++;
			}
			return !!isOccupied;		
		}
	}

	// Place a tree at every edge square on our grid of 16x16 tiles
	var currentGame = this;	
	this.generateMap = function(){
		for (var x = 0; x < Game.map_grid.width; x++) {
			for (var y = 0; y < Game.map_grid.height; y++) {
				var at_edge = x == 0 || x == Game.map_grid.width - 1 || y == 0 || y == Game.map_grid.height - 1;

				if (at_edge) {
					// Place a tree entity at the current tile
					Crafty.e('Tree').at(x, y);
					currentGame.occupied[x][y] = true;
				}
				 else if (Math.random() < 0.06 && !currentGame.occupied[x][y]) {
					// Place a bush entity at the current tile
					var grass_or_rock = (Math.random() > 0.3) ? 'Grass' : 'Rock'
					Crafty.e(grass_or_rock).at(x, y);
					currentGame.occupied[x][y] = true;
				}
			}
		}
	}
	var craftyEntities =[];
	//on recupere les Entities  
	var getEntities = function(){
		if(ISDEBUG){
			console.log(Game.gameDatas.mapObjects.dataEntities);
			return Game.gameDatas.mapObjects.dataEntities;
		}
	};
	
	var dataEntities = getEntities();

	var createEntities = function() {
		// pour chaque entité dans les data
  	   	for (var entity in dataEntities) {

  	        	var entityC = dataEntities[entity];
			// on crée l'entité
           		craftyEntities[entityC.name] = Crafty.e(entityC.components).at(entityC.attr.x,entityC.attr.y,entityC.attr.h,entityC.attr.w);
		
		// si de type moveable on lui ajout le drag and drop
			if(entityC.type == "moveable"){
		
				craftyEntities[entityC.name]
				    .bind("StartDrag", function() {
					//ici on fera le test pour savoir si on peut poser
                        	        console.log("START1" + this.x + " " + this.y + " at " + this.at().x+ " " + this.at().y);
                            })
                            .bind("StopDrag", function() {
				//ici on fera le test pour savoir si on peut poser
				// si oui on enregistrera ca dans Game.gameDatas
                                console.log("STOP1" + this.x + " " + this.y);
                            })
                            .bind("HitOn", function(hitData) {
                                console.log("Collision with Solid entity occurred for the first time.");
				
console.log(hitData);
                            })
                            .bind("HitOff", function(comp) {
                                console.log("Collision with Solid entity ended.");

console.log(comp);
                            });

       		 }
	}
    };
	console.log(Game);
	this.generateMap();
	if(!this.isOccupied(10,10)){
		Crafty.e('House').at(10,10);
	}  
	createEntities();
	
});

Crafty.scene('Loading', function(){
	// Draw some text for the player to see in case the file
	//  takes a noticeable amount of time to load
	Crafty.e('2D, DOM, Text')
		.text('Loading; please wait...')
		.attr({ x: 0, y: Game.height()/2 - 24, w: Game.width() })
		.textFont({});

	// Load our sprite map image
	console.log(Game.gameDatas);
	Game.getData();
	console.log(Game.gameDatas.mapObjects.sprites);
	Crafty.load({sprites:Game.gameDatas.mapObjects.sprites}, function(){
		// Once the images are loaded...
		Crafty.scene('Town');
	});
});

