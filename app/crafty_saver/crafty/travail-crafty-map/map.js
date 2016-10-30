var CraftyMap = (function() {
    'use strict';
    //Surface de jeu
    Crafty.init(1000, 600, document.getElementById('scene'));
		Crafty.background('url(img/damier.jpg)');


    Crafty.load(obj, // preload assets
        function() { //when loaded
            Crafty.scene("main"); //go to main scene
            Crafty.e('2D, DOM, lazycat'); // create entity with sprite
        },
        function(e) { //progress
        },

        function(e) { //uh oh, error loading
        }
    );

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
                components: "2D,DOM,map,house1, Collision,Mouse, Draggable",
                attr: {
                    x: 470,
                    y: 0,
                    w: 400,
                    h: 400
                }
            }, {
                type: 'moveable',
                name: 'warehouse',
                components: "2D,DOM,map,house1,solid,Collision,Mouse, Draggable",
                attr: {
                    x: 0,
                    y: 150,
                    w: 255,
                    h: 217
                }
            }, {
                type: 'moveable',
                name: 'desk',
                components: "2D,DOM,map,desk,solid,Collision,Mouse, Draggable",
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


        // On gere l'echelle des entites crafty
        var scaleEntity = function(obj, sc){
            var att = {};
            att.x = obj.x/10*sc;
            att.y = obj.y/10*sc;
            att.w = obj.w/10*sc;
            att.h = obj.h/10*sc;
            return att;
        };
            //On cree les entites crafty
        var createEntity = function() {
            for (var entity in dataEntities) {
                var entityC = dataEntities[entity];

                craftyEntities[entityC.name] = Crafty.e(entityC.components).attr(scaleEntity(entityC.attr, 5));

                // if(entityC.type == 'moveable') {
                //     craftyEntities[entityC.name]
                //         .bind("StartDrag", function() {
                //             console.log("START1" + this.x + " " + this.y);
                //         })
                //         .bind("StopDrag", function() {
                //             console.log("STOP1" + this.x + " " + this.y);
                //         })
                //         .bind("HitOn", function(hitData) {
                //             console.log("Collision with Solid entity occurred for the first time.");
                //         })
                //         .bind("HitOff", function(comp) {
                //             console.log("Collision with Solid entity ended.")
                //         });
                //         //.checkHits('Solid'); // check for collisions with entities that have the Solid component in each frame;
                //
                // }
            }
        };

        createSprits();
        createEntity();
    });

    Crafty.scene("game"); //start the game
    console.log("fin");

})();
