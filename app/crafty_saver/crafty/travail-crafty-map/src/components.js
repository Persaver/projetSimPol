// The Grid component allows an element to be located
//  on a grid of tiles

Crafty.c('Grid', {
  init: function() {
    this.attr({
      w: 1,
      h: 1 
    })
  },

  // Locate this entity at the given position on the grid
  at: function(x, y, w ,h) {
	// si on ne passe pas de parametre rnvois la position et la taille
    if (x === undefined && y === undefined) {
      return { x: this.x/Game.map_grid.tile.width, y: this.y/Game.map_grid.tile.height, h: this.h/Game.map_grid.tile.height, w: this.w/Game.map_grid.tile.width}
    } else if (w === undefined && h === undefined)  { //si on passe que x et y fixe la position et met la taille a h=une tuille et w=une tuille 
      this.attr({ x: x * Game.map_grid.tile.width, y: y * Game.map_grid.tile.height,w:Game.map_grid.tile.width, h:Game.map_grid.tile.height});
      return this;
    } else { // fixe la position et la taille 
      this.attr({ x: x * Game.map_grid.tile.width, y: y * Game.map_grid.tile.height,w: w * Game.map_grid.tile.width, h: h * Game.map_grid.tile.height});
      return this;
    } 
  }
});

// An "Actor" is an entity that is drawn in 2D on canvas
//  via our logical coordinate grid
Crafty.c('Actor', {
  init: function() {
    this.requires('2D,Solid, Canvas, Grid');
  },
});

Crafty.c('Tree', {
  init: function() {
    this.requires('Actor,spr_grass');
  },
});

Crafty.c('Grass', {
  init: function() {
    this.requires('Actor, spr_grass');
  },
});

Crafty.c('Rock', {
  init: function() {
    this.requires('Actor, spr_grass');
  },
});

Crafty.c('Moveable', {
  init: function() {
	this.requires('Actor,Collision,Mouse,Draggable');
  },
});

Crafty.c('House', {
  init: function() {
    this.requires('Actor, spr_house_1');
  },
});
Crafty.c('Warehouse', {
  init: function() {
    this.requires('Moveable,spr_warehouse');
  },
});
Crafty.c('Desk', {
  init: function() {
    this.requires('Moveable,spr_desk');
  },
});
Crafty.c('Museum', {
  init: function() {
    this.requires('Moveable,spr_museum');
  },
});
