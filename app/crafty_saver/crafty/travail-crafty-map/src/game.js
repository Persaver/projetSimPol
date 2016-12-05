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
        width: 160,
        height: 160,
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
        Crafty.viewport.init(640, 640);
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

        if (typeof container == "undefined") {
            container = document.getElementById("crafty-contex-content");
        }
        container.innerHTML = "";
        var newListe = document.createElement('ul');
        container.appendChild(newListe);
        if (data.id != undefined) {
            id = data.id.toLowerCase();
        }
        console.log(data);


        if (Game.gameDatas.mapObjects.dataEntities[id] != undefined && Game.gameDatas.mapObjects.dataEntities[id].informations != undefined) {
            var informations = Game.gameDatas.mapObjects.dataEntities[id].informations;



            for (key in informations) {
                //label
                var a=key;
                //valeur
                console.log(informations);
                console.log(Game.gameDatas.mapObjects.dataEntities[id]);
                var b=informations[key];
                var label=new Array();
                label[0]="nb_salarie";
                label[1]="nombre de salariés";
                label[2]="nb_cadre";
                label[3]="nombre de cadres";

                for(var i=0;i<=label.length;i++){
                    if(a==label[i]){
                      a=label[i+1];
                      console.log(a);
                      console.log(i);
                      break;
                  }
                }


                var newPuce = document.createElement('li');
                newListe.appendChild(newPuce);
                var newP= document.createElement('p');
                newP.className ="itemKey";
                newP.id="indicateur";
                newP.innerHTML=a;

                newPuce.appendChild(newP);
                var newP2 = document.createElement('p');
                newP2.className = "itemValue";
                newP2.id="valeur_indicateur";
                newP2.innerHTML = b;
                newPuce.appendChild(newP2);

            }

            }
            var newPuce = document.createElement('li');
            newListe.appendChild(newPuce);
            var newP= document.createElement('p');
            newP.className ="itemKey";
            newP.id="delete";
            newP.innerHTML="supprimer";

            newPuce.appendChild(newP);
            var newP2 = document.createElement('p');
            newP2.className = "itemValue";
            newP2.id="deleteFlag";
            newP2.innerHTML = "X";
            newPuce.appendChild(newP2);
            newPuce.onclick=function(){
              console.log(data);
              Game.removeCraftyEntity(data.item);
        }
        //container.innerHTML = data.message;
    },

    clearContextual:function(container){
      if (typeof container == "undefined") {
          container = document.getElementById("crafty-contex-content");
      }
      container.innerHTML = "";
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
    removeCraftyEntity: function(dataEntite) {
      console.log(dataEntite);
        // ici on fera l'ajax

        //on lance l'appel a crafty
        Crafty.trigger("RemoveEntity", dataEntite);
    },

    zoom: function(callback) {
        var zoom_inBtn = document.getElementById("zoom_in");
        var zoom_outBtn = document.getElementById("zoom_out");
        //Le zoom min est de 1 & le zoom max est de 3
        var echelle = 1;
        var maxScale = 3;
        var minScale = 0.5;
        var pas= 0.5;
        zoom_outBtn.onclick = function() {
            if (echelle > minScale && echelle <= maxScale) {
              console.log("test");
                echelle-=pas;
            }
            callback(echelle);
            console.log(echelle);
        };

        zoom_inBtn.onclick = function() {
            if (echelle>=minScale && echelle<maxScale ) {
                echelle+=pas;
            }
            callback(echelle);
            console.log(echelle);
        };



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
