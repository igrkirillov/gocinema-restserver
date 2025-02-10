create table movie (
	id serial primary key, 
	name varchar(256), 
	description text, 
	country varchar(64), 
	release_date date,
	duration int);
comment on table movie is 'Фильм'; 

create table hall (
	id serial primary key, 
	name varchar(256) not null, 
	x_size int not null, 
	y_size int not null,
	st_price int not null,
	vip_price int not null);
comment on table hall is 'Кинозал';
	
create table hall_place (
	id serial primary key,
	hall_id int not null references hall(id),
	x_value int not null,
	y_value int not null,
	is_vip boolean not null default false
	);
comment on table hall_place is 'Зрительское место';
	
create table movie_show (
	id serial primary key,
	movie_id int not null references movie(id),
	hall_id int not null references hall(id),
	start_time time(4) not null,
	end_time time(4) not null
	);
comment on table movie_show is 'Сеанс';

create table "user" (
	id serial primary key,
	login varchar(256) not null,
	password varchar(256) not null, -- hashed string
	role varchar(256) not null --viewer or administartor
);
comment on table "user" is 'Пользователь';
comment on column "user"."role" is 'viewer or administartor';
	
create table movie_show_place (
	id serial primary key,
	movie_show_id int not null references movie_show(id),
	hall_place_id int not null references hall_place(id),
	is_booked boolean not null default false
);
comment on table movie_show_place is 'Место на сеанс';

create table ticket (
	id serial primary key,
	user_id int not null references "user"(id),
	qr_code varchar(256) not null,
	movie_show_place_id int null references movie_show_place(id)
);
comment on table ticket is 'Билет';