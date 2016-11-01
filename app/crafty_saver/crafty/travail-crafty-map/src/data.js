var spl_debugJson = {
    "mapObjects": {
        "dataEntities": {
            // crée des données comme celles que l'on devrait recuperer sur le serveur
	    "house1": {
		// type actuelement pas utile 
                "type": "fixed",
		// les components pour l'entitée Crafty definit dans components.js
                "components": "House",
		// position et taile en tuile sur la map
                "attr": {
                    "x": 20,
                    "y": 20,
                    "w": 2,
                    "h": 1
                }
            },
            "museum": {
                "type": "moveable",
                "components": "Museum",
                "attr": {
                    "x": "4",
                    "y": "10",
                    "w": "4",
                    "h": "4"
                }
            },
            "warehouse": {
                "type": "moveable",
                "components": "Warehouse",
                "attr": {
                    "x": 30,
                    "y": 5,
                    "w": 2,
                    "h": 2
                }
            },
            "desk": {
                "type": "moveable",
                "components": "Desk",
                "attr": {
                    "x": 30,
                    "y": 16,
                    "w": 2,
                    "h": 1
                }
            },
	// tu rajoute un object ici avec des coords une taille en tuile et le components definit dans components.js
	// ex pour Church
	   "church" : {
		"type" : "moveable",
		"components" : "Church",
		"attr":{
			"x":5,
			"y":25,
			"w":2,
			"h":2
		}
	   }
        },

        "sprites": {
            "./img/buildings-icon.png": {
                // on indique la tuile a 1px
                "tile": 1,
                "tileh": 1,
                "map": {
                    "spr_house_1": [0, 0, 287, 100],
                    "spr_house_2": [800, 220, 80, 100],
                    "spr_house_3": [402, 121, 128, 76],
                    "spr_house_4": [947, 113, 61, 82],
                    "spr_museum": [592, 210, 208, 125],
                    "spr_warehouse": [13, 545, 255, 217],
                    "spr_desk": [0, 772, 44, 170],
                    "spr_church": [880, 206, 122, 124],
                    "spr_restaurant": [934, 12, 81, 88],
                    "spr_night_club": [786, 17, 78, 80],
                    "spr_temple": [350, 816, 162, 149],
                    "spr_temple_tower": [569, 531, 61, 163],
                    "spr_farm": [275, 560, 206, 118],
                    "spr_rescue_tower": [612, 799, 106, 184],
                    "spr_circus": [736, 354, 178, 165],
                    "spr_television": [0, 342, 148],
                    "spr_entertainment_hall": [240, 386, 65, 164],
                }
            },

            "./img/ground.png": {
                "tile": 1,
                "tileh": 1,
                "map": {
                    "spr_grass": [0, 125, 60, 60]
                }
            },

            "./img/building_icon_4.png": {
                "tile": 1,
                "tileh": 1,
                "map": {
                    "spr_military_place": [0, 495, 194, 225],
                    "spr_military_tower": [0, 223, 114, 261],
                    "spr_factory":[80, 91, 175, 118],
                }
            },

            "img/building_icon_3.png": {
                "tile": 1,
                "tileh": 1,
                "map": {
                    "spr_hospital": [737, 700, 150, 169],
                    "spr_police_dpt": [680, 258, 105, 153]
                }
            },

            "img/building_icon_2.png": {
                "tile": 1,
                "tileh": 1,
                "map": {
                    "spr_university": [165, 301, 130, 121]
                }
            }

        }
    }
};
