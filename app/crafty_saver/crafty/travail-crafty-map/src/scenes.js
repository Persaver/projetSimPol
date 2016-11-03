Crafty.scene('Town', function(){
	// varibale pour tester sans serveur
	var ISDEBUG = true;

	var currentScene = this;	
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
	// mofifer pour params ArrayOrObject
	this.isOccupied = function(ArrayOrObject){
		var x,y,w,h;
		
		if (!Array.isArray(ArrayOrObject)){
			x =  ArrayOrObject.x;
			y =  ArrayOrObject.y;
			w =  ArrayOrObject.h;
			h =  ArrayOrObject.h;
		}
		else {
			x = ArrayOrObject[0];
			y = ArrayOrObject[1];
			if (ArrayOrObject.lenght = 4){
				w =  ArrayOrObject[2];
				h =  ArrayOrObject[3];
			}
		}
	
		if( h === undefined || w === undefined){
			return this.occupied[x][y];
		} else{
			var isOccupied = false;
			var i=0,j;
			while (!isOccupied && i < w && ((x+i) < this.occupied.length )){
				j=0;
				while ( !isOccupied && j < h && ((y+j) < this.occupied[i].length) ){
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
	// Occupied metr
	this.setOccupied = function(ArrayOrObject,occupied){
		var x,y,w,h;

		if (!Array.isArray(ArrayOrObject)){
			x =  ArrayOrObject.x;
			y =  ArrayOrObject.y;
			w =  ArrayOrObject.h;
			h =  ArrayOrObject.h;
		}
		else {
			x = ArrayOrObject[0];
			y = ArrayOrObject[1];
			if (ArrayOrObject.lenght = 4){
				w =  ArrayOrObject[2];
				h =  ArrayOrObject[3];
			}
		}

		if( h === undefined && w == undefined){
			this.occupied[x][y] = occupied;
		} else{
			var i=0,j;
			while (i < w && ((x+i) < this.occupied.length )){
				j=0;
				while (j < h && ((y+j) < this.occupied[i].length) ){
					this.occupied[x+i][y+j] = occupied;
					console.log(this.occupied[x+i][y+j]);
					j++;
				}
				i++;
			}
				
		}
	}

	// Place a tree at every edge square on our grid of 16x16 tiles

	this.generateMap = function(){
		for (var x = 0; x < Game.map_grid.width; x++) {
			for (var y = 0; y < Game.map_grid.height; y++) {
				var at_edge = x == 0 || x == Game.map_grid.width - 1 || y == 0 || y == Game.map_grid.height - 1;

				if (at_edge) {
					// Place a tree entity at the current tile
					Crafty.e('Tree').at([x, y]);
					currentScene.occupied[x][y] = true;
				}
				 else if (Math.random() < 0.06 && !currentScene.occupied[x][y]) {
					// Place a bush entity at the current tile
					var grass_or_rock = (Math.random() > 0.3) ? 'Grass' : 'Rock'
					Crafty.e(grass_or_rock).at([x, y]);
					currentScene.occupied[x][y] = true;
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
			console.log(entityC);
           		craftyEntities[entityC.name] = Crafty.e(entityC.components).at([entityC.attr.x,entityC.attr.y,entityC.attr.h,entityC.attr.w]);
			// on les ajoute à la map
			currentScene.setOccupied(entityC.attr);
		// si de type moveable on lui ajout le drag and drop
			if(entityC.type == "moveable"){
				craftyEntities[entityC.name].oldPos = craftyEntities[entityC.name].at();
				craftyEntities[entityC.name]
				    .bind("StartDrag", function() {
					//ici on fera le test pour savoir si on peut poser
                        	        console.log("START1" + this.x + " " + this.y + " at " + this.at().x+ " " + this.at().y);
					currentScene.setOccupied(this.oldPos,false);
					console.log(this.oldPos);
				//	console.log(Crafty.rectManager.overlap(this,this));
				console.log(this);
                            })
                            .bind("StopDrag", function() {
				//ici on fera le test pour savoir si on peut poser
				// si oui on enregistrera ca dans Game.gameDatas
                                console.log("STOP1" + this.x + " " + this.y);
					// ON LE PLACE GRACE AUX LONGEURS DE TUILE DE LA GRILLE
					console.log(currentScene.isOccupied(this.at()));
					if(currentScene.isOccupied(this.at())){
						this.at(this.oldPos);	
					}
					else{
						this.at(this.at());
						this.oldPos = this.at();
					}
		
					currentScene.setOccupied(this.at(),true);
			//	console.log(this);
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
	console.log(typeof [10,10]);
	if(!this.isOccupied([10,10])){
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

