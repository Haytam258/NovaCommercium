drop database if exists novadb;

create database if not exists novadb;

use novadb;

create table categorie(
	id int primary key auto_increment,
    name varchar(255)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

create table cooperative(
	id int primary key auto_increment,
    name varchar(255),
    numero_de_tel int
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

create table origine(
	id int primary key auto_increment,
    endroit varchar(255)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

create table produit(
	id int primary key auto_increment,
    description varchar(255),
    name varchar(255),
    prix double,
    unite int
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

create table matiere_premiere(
	id int primary key auto_increment,
	name varchar(255)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

create table region(
	id int primary key auto_increment,
    name varchar(255)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

create table secteur(
	id int primary key auto_increment,
    name varchar(255)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

create table origine_matiere(
    origine_id int,
    matiere_id int,
    primary key(origine_id, matiere_id),
    foreign key(origine_id) references origine(id),
    foreign key(matiere_id) references matiere_premiere(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

create table origine_produit(
    origine_id int,
    produit_id int,
    primary key(origine_id, produit_id),
    foreign key(origine_id) references origine(id),
    foreign key(produit_id) references produit(id)
    
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

create table produit_matiere(
    produit_id int,
    matiere_id int,
    primary key(produit_id, matiere_id),
    foreign key(matiere_id) references matiere_premiere(id),
    foreign key(produit_id) references produit(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

create table Client(
	id int primary key auto_increment,
    username varchar(255),
    password varchar(255)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO Client VALUES(1,"testing", "testing");
INSERT INTO produit VALUES(1,"something","name",100,2);
INSERT INTO produit VALUES(2,"something2","name2",200,4);
INSERT INTO produit VALUES(3,"something3","name3",100,5);

INSERT INTO origine VALUES(1,"unEndroit");
INSERT INTO origine VALUES(2,"unAutreEndroit");
INSERT INTO origine VALUES(3,"endroitDifferent");

INSERT INTO matiere_premiere VALUES(1,"somethingElse");
INSERT INTO matiere_premiere VALUES(2,"hidden_something");


INSERT INTO produit_matiere VALUES(1,2);
INSERT INTO produit_matiere VALUES(2,2);
INSERT INTO produit_matiere VALUES(2,1);

INSERT INTO origine_matiere VALUES(3,2);
INSERT INTO origine_matiere VALUES(2,2);


