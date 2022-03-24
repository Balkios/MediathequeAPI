


insert into MEMBRE (EMAIL, PASSWORD, NOM, PRENOM) values ('dthibau@wmmod.com', 'secret','THIBAU','David');
insert into MEMBRE (EMAIL, PASSWORD, NOM, PRENOM) values ('dthibau@mymeetingsondemand.com', 'secret','THIBAU','Michel');
insert into MEMBRE (EMAIL, PASSWORD, NOM, PRENOM) values ('david.thibau@gmail.com', 'secret','THIBAU','Gaston');
insert into MEMBRE (EMAIL, PASSWORD, NOM, PRENOM) values ('toto@titi.com', 'secret','TITI','Toto');

insert into DOCUMENT (TITRE, NBRE_EXEMPLAIRES, DATE_PARUTION, DISPONIBLE) values ('CD1', 3, '1987-08-15',true);
insert into DOCUMENT (TITRE, NBRE_EXEMPLAIRES, DATE_PARUTION, DISPONIBLE) values ('CD2', 2, '1977-08-15',true);

insert into DOCUMENT (TITRE, NBRE_EXEMPLAIRES, DATE_PARUTION, DISPONIBLE) values ('DVD1', 1, '1987-06-28',true);
insert into DOCUMENT (TITRE, NBRE_EXEMPLAIRES, DATE_PARUTION, DISPONIBLE) values ('DVD2', 1, '1987-11-08',true);

insert into DOCUMENT (TITRE, NBRE_EXEMPLAIRES, DATE_PARUTION, DISPONIBLE) values ('livre1', 1, '2016-06-28',true);
insert into DOCUMENT (TITRE, NBRE_EXEMPLAIRES, DATE_PARUTION, DISPONIBLE) values ('livre2', 1, '2017-11-08',true);


insert into DOCUMENT (TITRE, NBRE_EXEMPLAIRES, DATE_PARUTION, DISPONIBLE) values ('livre new 1', 1, '2022-03-15',true);
insert into DOCUMENT (TITRE, NBRE_EXEMPLAIRES, DATE_PARUTION, DISPONIBLE) values ('CD new 1', 1, '2022-02-28',true);
insert into DOCUMENT (TITRE, NBRE_EXEMPLAIRES, DATE_PARUTION, DISPONIBLE) values ('DVD new 1', 1, '2022-03-22',true);


insert into CD (ARTISTE_GROUPE, DUREE,NBRE_TITRES, ID) values ('artiste1', 120,6,1);
insert into CD (ARTISTE_GROUPE, DUREE,NBRE_TITRES, ID) values ('artiste2', 125,11,2);
insert into CD (ARTISTE_GROUPE, DUREE,NBRE_TITRES, ID) values ('artiste3', 114,5,8);


insert into DVD (REALISATEUR, DUREE, TYPE, ID) values ('Realisateur1', 158, 'NORMAL',3);
insert into DVD (REALISATEUR, DUREE, TYPE, ID) values ('Realisateur2', 159, 'BLUE_RAY',4);
insert into DVD (REALISATEUR, DUREE, TYPE, ID) values ('Realisateur3', 150, 'BLUE_RAY',9);

insert into LIVRE (ECRIVAIN, NUMERO_ISBN, ID) values ('ecrivain1', 159,5);
insert into LIVRE (ECRIVAIN, NUMERO_ISBN, ID) values ('ecrivain2', 150,6);
insert into LIVRE (ECRIVAIN, NUMERO_ISBN, ID) values ('ecrivain3', 1558,7);


insert into emprunte (date_creation, date_retour , document_id , membre_id) values ('2022-03-22','2022-03-29',1,1);
insert into emprunte (date_creation, date_retour , document_id , membre_id) values ('2022-03-22','2022-03-29',2,1);
insert into emprunte (date_creation, date_retour , document_id , membre_id) values ('2022-03-22','2022-03-29',3,1);



