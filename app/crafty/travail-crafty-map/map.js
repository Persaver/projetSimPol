
    //La surface de jeu est initialisées
    Crafty.scene("start-map", function() {
    Crafty.init(1000, 600, document.getElementById('scene'));
    //On va chercher le sprite
    Crafty.sprite("img/ground.png",{grass:[0,125,60,60]});
    //On l'applique à la surface de jeu
    var grass_tile=Crafty.e("2D, Canvas, DOM, grass");
    });
    Crafty.scene("start-map");

    //
     for (var i = 0; i < 50; i++) {
       for (var j = 0; j < 30; j++){
         Crafty.e('2D,Canvas, DOM, grass').attr({x: 20*i, y: 20*j, w: 20, h: 20})
      }
    }
