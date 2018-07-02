CREATE DATABASE  IF NOT EXISTS `jetons` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `jetons`;

#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------


#------------------------------------------------------------
# Table: equipe
#------------------------------------------------------------

CREATE TABLE equipe(
        id_equipe int (11) Auto_increment  NOT NULL ,
        id_projet Int NOT NULL ,
        id_chef   Int NOT NULL ,
        nom       Varchar (255) NOT NULL ,
        nb_jeton  Int NOT NULL ,
        id_sujet  Int NOT NULL ,
        PRIMARY KEY (id_equipe )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: specialite
#------------------------------------------------------------

CREATE TABLE specialite(
        id_spec    int (11) Auto_increment  NOT NULL ,
        specialite Varchar (255) NOT NULL ,
        id_user    Int NOT NULL ,
        PRIMARY KEY (id_spec )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: user
#------------------------------------------------------------

CREATE TABLE user(
        id_user     int (11) Auto_increment  NOT NULL ,
        identifiant Varchar (255) NOT NULL ,
        nom         Varchar (255) NOT NULL ,
        prenom      Varchar (255) NOT NULL ,
        mdp         Varchar (255) NOT NULL ,
        type_user   Int NOT NULL ,
		jeton_intervenant int (11),
        PRIMARY KEY (id_user )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: projet
#------------------------------------------------------------

CREATE TABLE projet(
        id_projet          int (11) Auto_increment  NOT NULL ,
        nom                Varchar (255) NOT NULL ,
        description        Varchar (255) NOT NULL ,
        description_courte Varchar (255) NOT NULL ,
        mot_clef1          Char (255) NOT NULL ,
        mot_clef2          Varchar (255) NOT NULL ,
        mot_clef3          Varchar (255) NOT NULL ,
        PRIMARY KEY (id_projet )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: mail
#------------------------------------------------------------

CREATE TABLE mail(
        id_mail    int (11) Auto_increment  NOT NULL ,
        sujet      Varchar (255) NOT NULL ,
        corps      Varchar (255) NOT NULL ,
        date_envoi Datetime NOT NULL ,
        lu         Bool NOT NULL ,
        id_user    Int NOT NULL ,
        id_user_1  Int NOT NULL ,
        PRIMARY KEY (id_mail )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: agenda
#------------------------------------------------------------

CREATE TABLE agenda(
        id_agenda      int (11) Auto_increment  NOT NULL ,
        id_intervenant Int NOT NULL ,
        id_equipe      Int NOT NULL ,
        date_debut     Datetime NOT NULL ,
        date_fin       Datetime NOT NULL ,
        reserve        Bool NOT NULL ,
        description    Varchar (255) NOT NULL ,
        id_equipe_1    Int NOT NULL ,
        id_user        Int NOT NULL ,
        PRIMARY KEY (id_agenda )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: sujet
#------------------------------------------------------------

CREATE TABLE sujet(
        id_sujet           int (11) Auto_increment  NOT NULL ,
        nom                Varchar (255) NOT NULL ,
        description        Varchar (255) NOT NULL ,
        description_courte Varchar (255) NOT NULL ,
        mot_clef1          Char (255) NOT NULL ,
        mot_clef2          Varchar (255) NOT NULL ,
        mot_clef3          Varchar (255) NOT NULL ,
        id_user            Int NOT NULL ,
        id_projet          Int NOT NULL ,
        PRIMARY KEY (id_sujet )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: appartenir à
#------------------------------------------------------------

CREATE TABLE appartenir_a(
        id_user   Int NOT NULL ,
        id_equipe Int NOT NULL ,
        PRIMARY KEY (id_user ,id_equipe )
)ENGINE=InnoDB;

ALTER TABLE equipe ADD CONSTRAINT FK_equipe_id_sujet FOREIGN KEY (id_sujet) REFERENCES sujet(id_sujet);
ALTER TABLE specialite ADD CONSTRAINT FK_specialite_id_user FOREIGN KEY (id_user) REFERENCES user(id_user);
ALTER TABLE mail ADD CONSTRAINT FK_mail_id_user FOREIGN KEY (id_user) REFERENCES user(id_user);
ALTER TABLE mail ADD CONSTRAINT FK_mail_id_user_1 FOREIGN KEY (id_user_1) REFERENCES user(id_user);
ALTER TABLE agenda ADD CONSTRAINT FK_agenda_id_equipe_1 FOREIGN KEY (id_equipe_1) REFERENCES equipe(id_equipe);
ALTER TABLE agenda ADD CONSTRAINT FK_agenda_id_user FOREIGN KEY (id_user) REFERENCES user(id_user);
ALTER TABLE sujet ADD CONSTRAINT FK_sujet_id_user FOREIGN KEY (id_user) REFERENCES user(id_user);
ALTER TABLE sujet ADD CONSTRAINT FK_sujet_id_projet FOREIGN KEY (id_projet) REFERENCES projet(id_projet);
ALTER TABLE appartenir_a ADD CONSTRAINT FK_appartenir_a_id_user FOREIGN KEY (id_user) REFERENCES user(id_user);
ALTER TABLE appartenir_a ADD CONSTRAINT FK_appartenir_a_id_equipe FOREIGN KEY (id_equipe) REFERENCES equipe(id_equipe);
