drop database if exists novadb;

create database if not exists novadb;

use novadb;

create table roles(
	id int primary key auto_increment,
    roles enum('ADMIN','CLIENT','UTILISATEUR')
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

create table categorie(
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

create table cooperative(
	id int primary key auto_increment,
    name varchar(255),
    numero_de_tel int,
    id_region int,
    id_secteur int,
    foreign key(id_region) references region(id),
    foreign key(id_secteur) references secteur(id)
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
    unite int,
    id_categorie int,
    id_cooperative int,
    foreign key(id_categorie) references categorie(id),
    foreign key(id_cooperative) references cooperative(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

create table matiere_premiere(
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

create table role_client(
	id_role int,
    id_client int,
    foreign key(id_client) references client(id),
    foreign key(id_role) references roles(id)
);

INSERT INTO Client VALUES(1,"testing", "testing");

INSERT INTO roles VALUES(1,"ADMIN");
INSERT INTO roles VALUES(2,"CLIENT");
INSERT INTO roles VALUES(3,"UTILISATEUR");

INSERT INTO role_client VALUES(1,1);

INSERT INTO secteur VALUES(1,"agricol");

INSERT INTO region VALUES(1, "SOUS MASSA");

INSERT INTO categorie VALUES(1, "unknown");
INSERT INTO categorie VALUES(2,"NotCosmetique");

INSERT INTO cooperative VALUES(1,"uknown","0651894562",1,1);

INSERT INTO produit VALUES(1,"something","name",100,2,1,1);
INSERT INTO produit VALUES(2,"something2","name2",200,4,2,1);
INSERT INTO produit VALUES(3,"something3","name3",100,5,1,1);

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



