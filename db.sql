DROP DATABASE IF EXISTS simpol;
CREATE DATABASE simpol
DEFAULT CHARACTER SET utf8;

USE simpol;

DROP TABLE IF EXISTS user;
CREATE TABLE user (
  id INT(3) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  pseudo VARCHAR(30) NOT NULL,
  password VARCHAR(50) NOT NULL
)ENGINE=InnoDB;

DROP TABLE IF EXISTS backup;
CREATE TABLE backup (
  id INT(4) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  date_creation DATETIME NOT NULL,
  date_last DATETIME NOT NULL,
  user INT(3) NOT NULL
)ENGINE=InnoDB;

DROP TABLE IF EXISTS categorie;
CREATE TABLE categorie (
  id INT(3) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  libelle VARCHAR(30) NOT NULL
)ENGINE=InnoDB;

DROP TABLE IF EXISTS construction;
CREATE TABLE construction (
  id INT(3) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  nom VARCHAR(30) NOT NULL,
  categorie INT(3) NOT NULL
)ENGINE=InnoDB;

DROP TABLE IF EXISTS position;
CREATE TABLE position (
  id INT(4) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  width INT(5) NOT NULL,
  height INT(5) NOT NULL
)ENGINE=InnoDB;

DROP TABLE IF EXISTS backup_construction_position;
CREATE TABLE backup_construction_position (
  backup INT(4) NOT NULL,
  construction INT(3) NOT NULL,
  position INT(4) NOT NULL,
  PRIMARY KEY (backup, construction, position)
)ENGINE=InnoDB;

DROP TABLE IF EXISTS backup_categorie;
CREATE TABLE backup_categorie(
  backup INT(4) NOT NULL,
  categorie INT(3) NOT NULL,
  PRIMARY KEY (backup, categorie)
)ENGINE=InnoDB;

ALTER TABLE backup
ADD FOREIGN KEY(user) REFERENCES user (id);
ALTER TABLE construction
ADD FOREIGN KEY(categorie) REFERENCES categorie (id);
ALTER TABLE backup_construction_position
ADD FOREIGN KEY(backup) REFERENCES backup (id);
ALTER TABLE backup_construction_position
ADD FOREIGN KEY(construction) REFERENCES construction (id);
ALTER TABLE backup_construction_position
ADD FOREIGN KEY(position) REFERENCES position (id);
ALTER TABLE backup_categorie
ADD FOREIGN KEY(categorie) REFERENCES categorie (id);
ALTER TABLE backup_categorie
ADD FOREIGN KEY(backup) REFERENCES backup (id);
