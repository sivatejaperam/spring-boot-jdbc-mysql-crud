DROP TABLE IF EXISTS Movies;
create table Movies
(
   id integer not null AUTO_INCREMENT,
   name varchar(255) not null, 
   directedBy varchar(255) not null,
   releasedDate datetime not null,
   primary key(id)
);