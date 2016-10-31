var spl_debugJson = {"mapObjects" :
{
 "dataEntities" : {
   "house1" :  {
      "type": "fixed",
      "components": "House",
      "attr": {
        "x": 20,
        "y": 20,
        "w": 2,
       	"h": 1
      }
    },
    "museum" : {
      "type": "moveable",
      "components": "Museum",
      "attr": {
      	"x": "4",
      	"y": "10",
      	"w": "4",
        "h": "4"
      }
    }, 
    "warehouse" : {
      "type": "moveable",
      "components": "Warehouse",
      "attr": {
        "x": 30,
        "y": 5,
        "w": 2,
        "h": 2
      }
    }, 
    "desk" : {
      "type": "moveable",
      "components": "Desk",
      "attr": {
        "x": 30,
	      "y": 16,
	      "w": 2,
	      "h": 1
	    }
    }
  },
	
	"sprites": {
            "./img/buildings-icon.png": {
		// on indique la tuile a 1px
           	"tile": 1,
            	"tileh": 1,
                "map" : {"spr_house_1":[0, 0, 287, 100],
                        "spr_house_2":[800, 220, 80, 100],
                        "spr_house_3":[402, 121, 128, 76],
			"spr_museum":[592,210,208,125],
			"spr_warehouse":[13,545,255,217],
			"spr_desk":[0,772,44,170]
		}
            },"img/ground.png":{
           	"tile": 1,
            	"tileh": 1,
		"map":{"spr_grass":[0,125,60,60]}
		}
	}
}};
