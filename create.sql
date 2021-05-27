create table caracteristique (id bigint not null auto_increment, attaque integer not null, defense integer not null, dribble integer not null, hauteur integer not null, pass integer not null, physique integer not null, piedfort varchar(255), poids double, precisio varchar(250) not null, position varchar(255), tir integer not null, vitesse integer not null, joueur_id bigint, primary key (id)) engine=InnoDB;
create table detailpartie (parties_id bigint not null, joueurs_id bigint not null) engine=InnoDB;
create table joueur (id bigint not null auto_increment, adresse varchar(255), disponibilite bit not null, nationalite varchar(255), nom varchar(255), password varchar(255), prenom varchar(255), scout_id bigint, primary key (id)) engine=InnoDB;
create table partie (id bigint not null auto_increment, stade varchar(255), primary key (id)) engine=InnoDB;
create table scout (id bigint not null auto_increment, email varchar(255), nom varchar(255), password varchar(255), prenom varchar(255), primary key (id)) engine=InnoDB;
create table video (id bigint not null auto_increment, format varchar(255), longeur varchar(255), name varchar(255), joueur_id bigint, primary key (id)) engine=InnoDB;
alter table caracteristique add constraint FKqq7qtyf4fh1kyr020mp8k1vbg foreign key (joueur_id) references joueur (id);
alter table detailpartie add constraint FK7eet6u6ahaqnil062bbcvniye foreign key (joueurs_id) references joueur (id);
alter table detailpartie add constraint FKdw5o3fo9r2mube6651vrxmyke foreign key (parties_id) references partie (id);
alter table joueur add constraint FKkenxpq9dmt11o6at7j8x42hnf foreign key (scout_id) references scout (id);
alter table video add constraint FKrx7bxugdg2h5o3nclu9yv2ibi foreign key (joueur_id) references joueur (id);