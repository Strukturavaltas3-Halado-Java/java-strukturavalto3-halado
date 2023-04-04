create table movies
(id bigint auto_increment,
title varchar(255),
length bigint,
average_rating double,
primary key (id));

create table movie_ratings
(movie_id bigint,
rating bigint,
foreign key (movie_id) references movies(id));
