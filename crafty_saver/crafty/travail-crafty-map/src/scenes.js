Crafty.scene('Town', function(){
	// varibale pour tester sans serveur
	//Rapport avec le crafty.scene de game.js ?????
	var ISDEBUG = true;

	var currentScene = this;

	var lastCenter = {};
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
		//console.log(ArrayOrObject);
		if (!Array.isArray(ArrayOrObject)){
			x =  ArrayOrObject.x;
			y =  ArrayOrObject.y;
			w =  ArrayOrObject.w;
			h =  ArrayOrObject.h;
		}
		else {
			x = ArrayOrObject[0];
			y = ArrayOrObject[1];
			if (ArrayOrObject.length == 4){
				w =  ArrayOrObject[2];
				h =  ArrayOrObject[3];
			}
		}
		if(x>=0 && y>=0){
			//console.log(x + " " +y+ " "+" "+w+" " +h )
			if( h === undefined || w === undefined){
				return this.occupied[x][y];
			} else{
				var isOccupied = false;
				var i=0,j;
				while (!isOccupied && i < w && ((x+i) < this.occupied.length )){
					j=0;
					while ( !isOccupied && j < h && ((y+j) < this.occupied[i].length) ){
						isOccupied |= this.occupied[x+i][y+j];
						//		console.log(this.occupied[x+i][y+j]);
						j++;
					}
					i++;
				}
				return !!isOccupied;
			}
		}else{	return true;	}
	}

	// passe a occupé les cases concernées
	// params x,y les coord de la tuile Facultatif w,h nombre de case en largeur et hauteur
	// Occupied metr
	this.setOccupied = function(ArrayOrObject,occupied = true){
		var x,y,w,h;

		if (!Array.isArray(ArrayOrObject)){
			x =  ArrayOrObject.x;
			y =  ArrayOrObject.y;
			w =  ArrayOrObject.w;
			h =  ArrayOrObject.h;
		}
		else {
			x = ArrayOrObject[0];
			y = ArrayOrObject[1];
			if (ArrayOrObject.length == 4){
				w =  ArrayOrObject[2];
				h =  ArrayOrObject[3];
			}
		}
		if(x>=0 && y>=0){
			if( h === undefined && w == undefined){
				this.occupied[x][y] = occupied;
			} else{
				var i=0,j;
				while (i < w && ((x+i) < this.occupied.length )){
					j=0;
					while (j < h && ((y+j) < this.occupied[i].length) ){
						this.occupied[x+i][y+j] = occupied;
						// console.log(this.occupied[x+i][y+j]);
						j++;
					}
					i++;
				}

			}
		}else{	return false;	}
	}

	// Place a tree at every edge square on our grid of 16x16 tiles

	this.generateMap = function(){
		for (var x = 0; x < Game.map_grid.width; x++) {
			for (var y = 0; y < Game.map_grid.height; y++) {
				var at_edge = x == 0 || x == Game.map_grid.width - 1 || y == 0 || y == Game.map_grid.height - 1;

				if (at_edge) {
					// Place a tree entity at the current tile
					Crafty.e('Rock').at([x, y]);

					currentScene.setOccupied([x, y],true);
				}
				if(x==Math.floor(Game.map_grid.width/2) || x==Math.floor(Game.map_grid.width/2) +1 || y==Math.floor(Game.map_grid.height/2) || y==Math.floor(Game.map_grid.height/2) +1){
					Crafty.e('Stone_Road').at([x,y]);
					currentScene.setOccupied([x, y],true);

				}else if(x==Math.floor(Game.map_grid.width/4) || x==Math.floor(Game.map_grid.width/4) * 3 || y==Math.floor(Game.map_grid.height/4) || y==Math.floor(Game.map_grid.height/4)* 3){
					Crafty.e('Stone_Road').at([x,y]);
					currentScene.setOccupied([x, y],true);
				}


			}
		}
	}
	var generateRandomEntities = function(){
		for (var x = 0; x < Game.map_grid.width; x++) {
			for (var y = 0; y < Game.map_grid.height; y++) {
				if (Math.random() < 0.06 && !currentScene.isOccupied([x, y])) {
					var grass_or_rock = (Math.random() > 0.3) ? 'Grass' : 'Rock';
					Crafty.e(grass_or_rock)
					.at([x, y])
					.bind("Click",function(){
						this.toggleClick();
						// console.log(""+this.isClick());
						this.display();
					});;

					currentScene.setOccupied([x, y],true);
				}
			}
		}
	}
	var craftyEntities =[];
	//on recupere les Entities
	var getEntities = function(){
		if(ISDEBUG){
			// console.log(Game.gameDatas.mapObjects.dataEntities);
			return Game.gameDatas.mapObjects.dataEntities;
		}
	};


	var createEntities = function(dataEntities) {
		var name = null;
		// console.log(dataEntities);
		// pour chaque entité dans les data
		for (var entity in dataEntities) {

			var entityC = dataEntities[entity];
			// on crée l'entité
			console.log(entityC);
			console.log(entityC.name);
			name ="" + entityC.components + entityC.attr.x + entityC.attr.y;
			entityC.name = name;
			craftyEntities[name] = Crafty.e(entityC.components).at([entityC.attr.x,entityC.attr.y,entityC.attr.w,entityC.attr.h]);
			craftyEntities[name].setName(entity);
			// on les ajoute à la map
			//console.log(craftyEntities[entityC.name].at());
			currentScene.setOccupied(craftyEntities[entityC.name].at(),true);

			// si de type moveable on lui ajout le drag and drop
			if(entityC.type == "moveable"){
				lastCenter = craftyEntities[entityC.name].at();
				craftyEntities[entityC.name].oldPos = craftyEntities[entityC.name].at();
				craftyEntities[entityC.name]
				.bind("StartDrag", function() {
					//ici on fera le test pour savoir si on peut poser
					// console.log("START1" + this.x + " " + this.y + " at " + this.at().x+ " " + this.at().y);
					currentScene.setOccupied(this.oldPos,false);
					// console.log(this.oldPos);
					//	console.log(Crafty.rectManager.overlap(this,this));
					// console.log(this);
				})
				.bind("StopDrag", function() {
					//ici on fera le test pour savoir si on peut poser
					// si oui on enregistrera ca dans Game.gameDatas
					// console.log("STOP1" + this.x + " " + this.y);
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
				})
				.bind("Click",function(){
					this.toggleClick();
					// console.log(""+this.isClick());
					this.display();
				});

			}
		}
	};
	// bind sur les Create Enty venu depuis l'esterieur de crafty
	// data type dataEntity
	this.createExternalEntity= function(){
		Crafty.bind("CreateEntity",function(data){
			console.log(data);
			var attr = this.getFirstPlace(data);
			if(attr){
				//	console.log(data[key]);
				//	console.log(attr);
				data.attr=attr;
				var nData = {};
				nData[data.components]=data;
				createEntities(nData);
				Crafty.viewport.centerOn(attr,1000);

			}

		});
	};
	// bind sur RemoveEntity
	// lance la function du components
	this.removeEntity= function(){
		Crafty.bind("RemoveEntity",function(data){
			console.log(data);
			currentScene.setOccupied(data.at(),false);
			data.removeEntity();
			Game.clearContextual();

		});
	};
	// trouve la premiere place disponible
	// params dataiEntity
	this.getFirstPlace= function(dataEntity){
		console.log(dataEntity);
		var attr = {
				x:0,
				y:0},
				isPlace=false;
		// si pas de param on met la taille est la hauteur à 1
		if(dataEntity == undefined){
			attr.w=1;
			attr.h=1;
		}else{
			attr.w=dataEntity.attr.w;
			attr.h=dataEntity.attr.h;
		}
		// des qu'on trouve on sort
		while(!isPlace && (attr.x+attr.w) < this.occupied.length){
			//console.log(isPlace + " " + attr.x+ " " +attr.y);
			attr.y=0;
			while(!isPlace && (attr.y+attr.h) < this.occupied[attr.x].length){
				isPlace = !this.isOccupied({x:attr.x,y:attr.y,w:attr.w,h:attr.h});
				attr.y++;
			}
			attr.x++;
		}

		if(isPlace){
			attr.x--;
			attr.y--;
			return attr;
		}else {
			return false;	}

	}

	this.setViewPort = function(value){
		console.log("callback");
		Crafty.viewport.scale(value);
	};

	this.centerViewPort = function(){
		console.log("callback");
		Crafty.viewport.centerOn(lastCenter,1000);
	};

	this.generateMap();
	var dataEntities = getEntities();
	createEntities(dataEntities);
	generateRandomEntities();
	this.createExternalEntity();
	Game.addMenuConstruction();
	Game.startTriggers();
	//this.setViewPort(4);
	//Crafty.viewport.scale(1);
	Crafty.viewport.mouselook(true);

	Game.zoom(this.setViewPort);
	Game.centerViewPort(this.centerViewPort);
	// tigerr remove entity
	this.removeEntity();
});

Crafty.scene('Loading', function(){
	// Draw some text for the player to see in case the file
	//  takes a noticeable amount of time to load
	Crafty.e('2D, DOM, Text')
	.text('Chargement en cours...')
	.attr({ x: Game.width()/3, y: Game.height()/2 - 24, w: Game.width() })
	.textFont({});

	// Load our sprite map image
	Game.getData()
	 console.log(Game.gameDatas);
	 console.log(Game.gameDatas.mapObjects.sprites);
	Crafty.load({sprites:Game.gameDatas.mapObjects.sprites}, function(){
		// Once the images are loaded...
		;
		Crafty.scene('Town');
	});
});
