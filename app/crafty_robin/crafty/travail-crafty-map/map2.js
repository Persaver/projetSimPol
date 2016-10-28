var CraftyMap = (function() {
    'use strict';
    //Surface de jeu
    Crafty.init(1000, 600, document.getElementById('scene'));
    Crafty.background('url(img/damier.jpg)');

    var assetsObj = {
        "sprites": {
            "./img/buildings-icon.png": {
                "map" : {}
                house1: [
                    0,
                    0,
                    287,
                    100
                ]
            },
            './img/buildings-icon.png': {
                house2: [
                    800,
                    220,
                    80,
                    100
                ]
            }
        }

    };

    Crafty.load(assetsObj, // preload assets
        function() {
            createSprits();
            createEntity();
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
            craftyEntities[entityC.name] = Crafty.e(entityC.components).attr(scaleEntity(entityC.attr, 5));
        }
    };
})();
