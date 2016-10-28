var CraftyMap = (function() {
    'use strict';
    //Surface de jeu
    Crafty.init(1000, 600, document.getElementById('scene'));
		Crafty.background('url(img/damier.jpg)');

    Crafty.scene("game", function() {
        //construction de la map
        var craftyEntities = [];
        var craftySprits = [];
        //ewemples de tableau données des sprits
        var dataEntities;
        //ewemples de tableau données des sprits
        var dataSprits = [{
            src: './img/buildings-icon.png',
            type: {
                house1: [
                    0,
                    0,
                    287,
                    100
                ]
            }
        }, {
            src: './img/buildings-icon.png',
            type: {
                house2: [
                    800,
                    220,
                    80,
                    100
                ]
            }
        }, {
            src: './img/buildings-icon.png',
            type: {
                house3: [
                    402,
                    121,
                    128,
                    76
                ]
            }
        }, {
            src: './img/buildings-icon.png',
            type: {
                museum: [
                    592,
                    210,
                    208,
                    125
                ]
            }
        }, {
            src: './img/buildings-icon.png',
            type: {
                warehouse: [
                    13,
                    545,
                    255,
                    217
                ]
            }
        }, {
            src: './img/buildings-icon.png',
            type: {
                desk: [0,
                    772,
                    244,
                    170
                ]
            }
        }];
        dataEntities = [{
                type: 'house',
                name: 'house_1',
                components: "2D,DOM,map,house1",
                attr: {
                    x: 0,
                    y: 0,
                    w: 287,
                    h: 100
                }
            }, {
                type: 'house',
                name: 'house_2',
                components: "2D,DOM,map,house1",
                attr: {
                    x: 287,
                    y: 0,
                    w: 80,
                    h: 100
                }
            }, {
                type: 'house',
                name: 'house_3',
                components: "2D,DOM,map,house2",
                attr: {
                    x: 830,
                    y: 200,
                    w: 128,
                    h: 76
                }
            }, {
                type: 'house',
                name: 'house_4',
                components: "2D,DOM,map,house2",
                attr: {
                    x: 830,
                    y: 50,
                    w: 128,
                    h: 76
                }
            }, {
                type: 'house',
                name: 'house_6',
                components: "2D,DOM,map,house3",
                attr: {
                    x: 700,
                    y: 0,
                    w: 128,
                    h: 76
                }
            }, {
                type: 'museum',
                name: 'museum',
                components: "2D,DOM,map,museum,solid,Collision,Mouse,Draggable",
                attr: {
                    x: 470,
                    y: 0,
                    w: 400,
                    h: 400
                }
            }, {
                type: 'warehouse',
                name: 'warehouse',
                components: "2D,DOM,map,warehouse,solid,Collision,Mouse,Draggable",
                attr: {
                    x: 0,
                    y: 150,
                    w: 255,
                    h: 217
                }
            }, {
                type: 'desk',
                name: 'desk',
                components: "2D,DOM,map,desk,solid,Collision,Mouse,Draggable",
                attr: {
                    x: 300,
                    y: 160,
                    w: 244,
                    h: 170
                }
            }

        ];
        // creation  des sprit grace au tableau dataSprits
        var createSprits = function() {
                for (var spritkey in dataSprits) {
                    var sprit = dataSprits[spritkey];
                    console.log(sprit);
                    Crafty.sprite(sprit.src, sprit.type);
                }
            };
            //On cree les entites crafty
        var createEntity = function() {
            for (var entity in dataEntities) {
                var entityC = dataEntities[entity];
								console.log(entityC);

                craftyEntities[entityC.name] = Crafty.e(entityC.components).attr(entityC.attr);
                switch (entityC.type) {
                    case "warehouse":
                    case "desk":
                    case "museum":
										console.log(craftyEntities[entityC.name]);
                        craftyEntities[entityC.name]
														.bind("StartDrag", function() {
                                console.log("START1" + this.x + " " + this.y);
                            })
                            .bind("StopDrag", function() {
                                console.log("STOP1" + this.x + " " + this.y);
                            })
                            .checkHits('Solid') // check for collisions with entities that have the Solid component in each frame
                            .bind("HitOn", function(hitData) {
                                console.log("Collision with Solid entity occurred for the first time.");
                            })
                            .bind("HitOff", function(comp) {
                                console.log("Collision with Solid entity ended.");
                            });
                        break;
                    case "house":
                        break;
                    default:
                        break;
                }
            }
        };

        createSprits();
        createEntity();
    });

    Crafty.scene("game"); //start the game
    console.log("fin");

})();
