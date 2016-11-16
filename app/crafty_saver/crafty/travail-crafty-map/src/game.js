Game = {
    // variable pour tester sans serveur
    ISDEBUG: true,
    // enembles des données du jeu a sauvegarder
    gameDatas: {
        // ensembles des objets sur la carte
        mapObjects: {}
    },


    //On définit ici la taille de la grille en unité tuile
    map_grid: {
        width: 40,
        height: 40,
        //On définit ici en Px la taille d'une tuile
        tile: {
            width: 16,
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

    getData: function(keyObject) {
        var data = {};
        if (this.ISDEBUG) {
            var dataJson = spl_debugJson;
            if (keyObject == undefined) {
                for (key in dataJson) {
                    console.log(dataJson[key]);
                    this.gameDatas[key] = dataJson[key];
                }
            } else {

            }

        } else {
            // ici on fera l'appel a Ajax pour recuperer depuis le serveur
        }


    },

    addMenuConstruction: function() {
        var data = {};
        var nb_case = 0;
        data = Game.gameDatas["menuConstruction"];
        console.log(data);
        var div = document.getElementById("crafty-construction-liste");
        var board = document.createElement('ul');
        board.id = 'board_icons';
        div.appendChild(board);

        if (data != undefined) {
            // On passe sur tout les element
            //
            for (var key in data) {
                nb_case = nb_case + 1;
                var newCase = document.createElement('li');
                var newDiv = document.createElement('DIV');
                newDiv.className += 'construction_icons';
                newCase.appendChild(newDiv);
                board.appendChild(newCase);
                newCase.id = "menu_" + key;
                console.log(data[key].type);
            }
        }
    },


    //affichage des information contextuelles
    //params object minimum   data: { message:"le message" }

    displayContextual: function(data, container) {
        var id;
        console.log("aaaa");
        if (typeof container == "undefined") {
            container = document.getElementById("crafty-contex-content");
        }
        if (data.id != undefined) {
            id = data.id.toLowerCase();
        }


        if (Game.gameDatas.mapObjects.dataEntities[id] != undefined && Game.gameDatas.mapObjects.dataEntities[id].informations != undefined) {
            var informations = Game.gameDatas.mapObjects.dataEntities[id].informations;

            for (key in informations) {
                console.log(key + " " +informations[key]);
            }

        }
        container.innerHTML = data.message;


    },



    //creation d'un element + ajout à crafty
    //params type dataEntite
    /*
               "house1": {
                    // type actuelement pas utile
                    "type": "fixed",
                    // les components pour l'entitée Crafty definit dans components.js
                    "components": "House",
                    // position et taile en tuile sur la map
                    "attr": {
                        "x": 1,
                        "y": 1,
                        "w": 6,
                        "h": 2
                    }
    */

    addCraftyEntity: function(dataEntite) {
        Crafty.trigger("CreateEntity", dataEntite);


    },

    //ajout des trigger
    startTriggers: function() {
            // ajout du trigger sur les div class constrution
            var constructions = document.getElementById("crafty-construction-liste").querySelectorAll("li");
            for (var key in constructions) {

                constructions[key].onclick = function(e) {

                    // console.log("click");
                    // var id = constructions[key];
                    // console.log("test" + constructions[key]);
                    // console.log("test" + id);
                    //
                    //console.log(id);
                    var id = this.id;
                    var tableau = id.split('menu_');
                    id = tableau[1];
                    var entity = Game.gameDatas.menuConstruction[id];
                    Game.addCraftyEntity(entity);


                    //     //   // recherche l'objet à la clef id
                    //     //   //stoker ds qq chose
                    //     //     console.log("click");
                    //     //     console.log(constructions[key]);
                    //     //     console.log(key);
                    //     //
                    //     //     Game.addCraftyEntity();
                }
            };

        }
        // ajout du trigger sur les div class constrution
}
