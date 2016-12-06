var CraftyMap = (function() {
    'use strict';
    //Surface de jeu
    Crafty.init(1000, 600, document.getElementById('scene'));
    Crafty.background('url(img/damier.jpg)');
    var dataEntities = [{
            type: 'fixed',
            name: 'house_1',
            components: "2D, DOM, map, house1",
            attr: {
                x: 0,
                y: 0,
                w: 287,
                h: 100
            }
        },  {
            type: 'moveable',
            name: 'museum',
            components: "2D,DOM,map,museum,Solid,Collision,Mouse,Draggable",
            attr: {
                x: 470,
                y: 0,
                w: 400,
                h: 400
            }
        }, {
            type: 'moveable',
            name: 'warehouse',
            components: "2D,DOM,map,warehouse,Solid,Collision,Mouse,Draggable",
            attr: {
                x: 0,
                y: 150,
                w: 255,
                h: 217
            }
        }, {
            type: 'moveable',
            name: 'desk',
            components: "2D,DOM,map,desk,Solid,Collision,Mouse,Draggable",
            attr: {
                x: 300,
                y: 160,
                w: 244,
                h: 170
            }
        }
    ];
    var assetsObj = {
        "sprites": {
            "./img/buildings-icon.png": {
           	"tile": 1,
            	"tileh": 1,
                "map" : {house1:[0, 0, 287, 100],
                        house2:[800, 220, 80, 100],
                        house3:[402, 121, 128, 76],
			museum:[592,210,208,125],
			warehouse:[13,545,255,217],
			desk:[0,772,44,170]
		}
            }
        }
    };
    var craftyEntities = [];
    Crafty.load(assetsObj, // preload assets
        function() {
//            Crafty.e("2D,DOM,map,house1,solid,Collision,Mouse, Draggable").attr(scaleEntity({ x: 0,y: 0,w: 287,h: 100}),5);
//            Crafty.e("2D,DOM,map,house1,solid,Collision,Mouse, Draggable").attr({ x: 0,y: 0,w: 287,h: 100});
            createEntity();
            console.log("a termine");
        },
        function(e) {
            console.log("toto ramirez");
        },
        function(e) {
            console.log("meurt un autre jour");
        }
    );


    var createSprits = function() {
        for (var spritkey in assetsObj) {
            var sprit = assetsObj[spritkey];
            console.log(sprit);
            Crafty.sprite(sprit.src, sprit.type);
        }
    };
    // On gere l'echelle des entites crafty
    var scaleEntity = function(obj, sc) {
        var att = {};
        att.x = obj.x / 10 * sc;
        att.y = obj.y / 10 * sc;
        att.w = obj.w / 10 * sc;
        att.h = obj.h / 10 * sc;
        return att;
    };
    //On cree les entites crafty
    var createEntity = function() {
        for (var entity in dataEntities) {
            var entityC = dataEntities[entity];
	    console.log(entityC);
      console.log("map2.js");
            craftyEntities[entityC.name] = Crafty.e(entityC.components).attr(scaleEntity(entityC.attr,5));
		var inMap = Crafty.map.insert(craftyEntities[entityC.name]);
		if(entityC.type == "moveable"){
		    console.log(craftyEntities[entityC.name]);

			craftyEntities[entityC.name]
			    .bind("StartDrag", function() {
                                console.log("START1" + this.x + " " + this.y);
				Crafty.map.refresh(inMap);
				console.log(Crafty.map);
                            })
                            .bind("StopDrag", function() {
                                console.log("STOP1" + this.x + " " + this.y);
                            })
                            .checkHits('Solid') // check for collisions with entities that have the Solid component in each frame
                            .bind("HitOn", function(hitData) {
                                console.log("Collision with Solid entity occurred for the first time.");
				this.css({"opacity":0.5});
console.log(hitData);
                            })
                            .bind("HitOff", function(comp) {
                                console.log("Collision with Solid entity ended.");

console.log(comp);
                            });

		    console.log(craftyEntities[entityC.name]);
       		 }
		console.log(inMap);
	}
	console.log(Crafty.map);
console.log(Crafty.map.boundaries());
    };
})();
