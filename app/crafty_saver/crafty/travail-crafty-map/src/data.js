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
                    "x": 1,
                    "y": 1,
                    "w": 6,
                    "h": 2
                }
            },
            "museum": {
                "type": "moveable",
                "components": "Museum",
                "attr": {
                    "x": "6",
                    "y": "11",
                    "w": "4",
                    "h": "4"
                }
            },
            "warehouse": {
                "type": "moveable",
                "components": "Warehouse",
                "attr": {
                    "x": 31,
                    "y": 7,
                    "w": 3,
                    "h": 3
                }
            },
            "police_Dpt": {
                "type": "moveable",
                "components": "Police_Dpt",
                "attr": {
                    "x": 8,
                    "y": 21,
                    "w": 2,
                    "h": 2
                }
            },
            //Sprite mal découpe
            "restaurant": {
                "type": "moveable",
                "components": "Restaurant",
                "attr": {
                    "x": 27,
                    "y": 11,
                    "w": 2,
                    "h": 2
                }
            },
            "Night_Club": {
                "type": "moveable",
                "components": "Night_Club",
                "attr": {
                    "x": 18,
                    "y": 11,
                    "w": 2,
                    "h": 2
                }
            },
            "Temple": {
                "type": "moveable",
                "components": "Temple",
                "attr": {
                    "x": 18,
                    "y": 22,
                    "w": 2,
                    "h": 2
                }
            },
            "Temple_Tower": {
                "type": "moveable",
                "components": "Temple_Tower",
                "attr": {
                    "x": 18,
                    "y": 28,
                    "w": 2,
                    "h": 2
                }
            },
            "Farm": {
                "type": "moveable",
                "components": "Farm",
                "attr": {
                    "x": 15,
                    "y": 28,
                    "w": 3,
                    "h": 2
                }
            },
            "Rescue_Tower": {
                "type": "moveable",
                "components": "Rescue_Tower",
                "attr": {
                    "x": 25,
                    "y": 25,
                    "w": 3,
                    "h": 3
                }
            },
            "Circus": {
                "type": "moveable",
                "components": "Circus",
                "attr": {
                    "x": 25,
                    "y": 35,
                    "w": 3,
                    "h": 3
                }
            },
            "Entertainment_Hall": {
                "type": "moveable",
                "components": "Entertainment_Hall",
                "attr": {
                    "x": 1,
                    "y": 27,
                    "w": 3,
                    "h": 3
                }
            },
            "Military_Place": {
                "type": "moveable",
                "components": "Military_Place",
                "attr": {
                    "x": 32,
                    "y": 27,
                    "w": 3,
                    "h": 3
                }
            },
            "Military_Tower": {
                "type": "moveable",
                "components": "Military_Tower",
                "attr": {
                    "x": 27,
                    "y": 15,
                    "w": 3,
                    "h": 5
                }
            },
            "Factory": {
                "type": "moveable",
                "components": "Factory",
                "attr": {
                    "x": 27,
                    "y": 6,
                    "w": 3,
                    "h": 4
                }
            },
            "Hospital": {
                "type": "moveable",
                "components": "Hospital",
                "attr": {
                    "x": 22,
                    "y": 0,
                    "w": 3,
                    "h": 4
                }
            },
            "University": {
                "type": "moveable",
                "components": "University",
                "attr": {
                    "x": 31,
                    "y": 16,
                    "w": 3,
                    "h": 4
                }
            },
            //Ne se positonne pas
            // "Television": {
            //     "type": "moveable",
            //     "components": "Television",
            //     "attr": {
            //         "x": 26,
            //         "y": 35,
            //         "w": 1,
            //         "h": 1
            //     }
            // },
            // ATTENTION SPRITE MAL DECOUPE
            // "desk": {
            //     "type": "moveable",
            //     "components": "Desk",
            //     "attr": {
            //         "x": 1.,
            //         "y": 16,
            //         "w": 4,
            //         "h": 4
            //     }
            // },
            // tu rajoute un object ici avec des coords une taille en tuile et le components definit dans components.js
            // ex pour Church
            "church": {
                "type": "moveable",
                "components": "Church",
                "attr": {
                    "x": 5,
                    "y": 25,
                    "w": 2,
                    "h": 2
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
                    "spr_entertainment_hall": [240, 386, 65, 164]
                }
            },

            "./img/ground.png": {
                "tile": 1,
                "tileh": 1,
                "map": {
                    "spr_grass": [0, 125, 60, 60],
                    "spr_stone_road": [0, 0, 60, 60],
                    "spr_stone_block": [500, 0, 60, 60]
                }
            },

            "./img/building_icon_4.png": {
                "tile": 1,
                "tileh": 1,
                "map": {
                    "spr_military_place": [0, 495, 194, 225],
                    "spr_military_tower": [0, 223, 114, 261],
                    "spr_factory": [80, 91, 175, 118]
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

        },
        //data de construction
        "menuConstruction": {
          //exemple de data renvoyer par le serveur
          // le type du data
          "church": {
              "type": "moveable",
              "components": "Church",
              //la hauteur et la largeur
              "attr": {
                  "w": 2,
                  "h": 2
              },
              //la src + la position du sprit dans la feuille
              "img" :{
                "src":"./img/menu-icon.png",
                "position":[595, 50, 50, 50]
              }
          }
          /*
            "sprite_sheet_icons": "./img/menu-icon.png",
            "ico_house": [595, 50, 50, 50],
            "ico_museum": [270, 420, 50, 50],
            "ico_warehouse": [81, 47, 50, 50],
            "ico_desk": [450, 227, 50, 50],
            "ico_church": [310, 600, 50, 50],
            "ico_restaurant": [32, 703, 50, 50],
            "ico_night_club": [177, 700, 46, 46],
            "ico_temple": [780, 700, 50, 50],
            "ico_temple_tower": [780, 700, 50, 50],
            "ico_farm": [270, 655, 50, 50],
            "ico_rescue_tower": [639, 6, 50, 50],
            "ico_circus": [460, 613, 50, 50],
            "ico_television": [691, 608, 50, 50],
            "ico_spr_entertainment_hall": [314, 237, 50, 50],
            "ico_military_place": [548, 888, 50, 50],
            "ico_military_tower": [80, 419, 50, 50],
            "ico_factory": [780, 838, 50, 50],
            "ico_hospital": [647, 46, 50, 50],
            "ico_police_dpt": [265, 611, 50, 50],
            "ico_university": [128, 562, 50, 50]
            */
        }
    }
};
