--наполняем базу для начального запуска

merge into _user(login, password, role)
key(login)
values ('admin', '{sha256}e3ce4bd09a18ada61afb69c3a5cece0bb03244b4caaeecf88a2e4e243e1c7ce5c4c21c2274b76b17', 'ADMIN');

merge into _user(login, password, role)
key(login)
values ('client', '{sha256}c08b0031f931857a9c93dbb003368fb2f248c5a7e89a95370c57a36b623320848daf83d899bad546', 'CLIENT');

merge into hall(name, cols, rows, st_price, vip_price)
key(name)
values ('Ролан', 2, 2, 100, 300);

merge into hall(name, cols, rows, st_price, vip_price)
key(name)
values ('Чаплин', 3, 3, 250, 550);

merge into hall_place(hall_id, _row, _col, is_vip, is_blocked)
key(hall_id, _row, _col)
values ((select id from hall where name = 'Ролан'), 0, 0, true, false);

merge into hall_place(hall_id, _row, _col, is_vip, is_blocked)
key(hall_id, _row, _col)
values ((select id from hall where name = 'Ролан'), 0, 1, false, true);

merge into hall_place(hall_id, _row, _col, is_vip, is_blocked)
key(hall_id, _row, _col)
values ((select id from hall where name = 'Ролан'), 1, 0, false, false);

merge into hall_place(hall_id, _row, _col, is_vip, is_blocked)
key(hall_id, _row, _col)
values ((select id from hall where name = 'Ролан'), 1, 1, false, false);

merge into hall_place(hall_id, _row, _col, is_vip, is_blocked)
key(hall_id, _row, _col)
values ((select id from hall where name = 'Чаплин'), 0, 0, true, false);

merge into hall_place(hall_id, _row, _col, is_vip, is_blocked)
key(hall_id, _row, _col)
values ((select id from hall where name = 'Чаплин'), 0, 1, true, false);

merge into hall_place(hall_id, _row, _col, is_vip, is_blocked)
key(hall_id, _row, _col)
values ((select id from hall where name = 'Чаплин'), 0, 2, true, false);

merge into hall_place(hall_id, _row, _col, is_vip, is_blocked)
key(hall_id, _row, _col)
values ((select id from hall where name = 'Чаплин'), 1, 0, true, false);

merge into hall_place(hall_id, _row, _col, is_vip, is_blocked)
key(hall_id, _row, _col)
values ((select id from hall where name = 'Чаплин'), 1, 1, true, false);

merge into hall_place(hall_id, _row, _col, is_vip, is_blocked)
key(hall_id, _row, _col)
values ((select id from hall where name = 'Чаплин'), 1, 2, true, false);

merge into hall_place(hall_id, _row, _col, is_vip, is_blocked)
key(hall_id, _row, _col)
values ((select id from hall where name = 'Чаплин'), 2, 0, false, false);

merge into hall_place(hall_id, _row, _col, is_vip, is_blocked)
key(hall_id, _row, _col)
values ((select id from hall where name = 'Чаплин'), 2, 1, false, false);

merge into hall_place(hall_id, _row, _col, is_vip, is_blocked)
key(hall_id, _row, _col)
values ((select id from hall where name = 'Чаплин'), 2, 2, false, false);

merge into movie(name, description, duration, country, release_date, poster_url)
key(name)
values ('Звёздные войны XXIII: Атака клонированных клонов', 'Фильм о звёздных войнах. Фантастика.', 130, 'США', '1990-01-01',
'/posters?fileName=poster.png');

merge into movie(name, description, duration, country, release_date)
key(name)
values ('Миссия выполнима', 'В главной роли Шварц', 120, 'США', '1991-02-08');

merge into movie(name, description, duration, country, release_date)
key(name)
values ('Серая пантера', 'Про пантеру', 90, 'США', '1986-02-02');

merge into movie(name, description, duration, country, release_date)
key(name)
values ('Движение вбок', 'Про спорт', 95, 'Испания', '2000-08-02');

merge into movie(name, description, duration, country, release_date)
key(name)
values ('Кот Да Винчи', 'Документалка', 100, 'Италия', '2010-09-01');

merge into movie_show(hall_id, movie_id, start)
key(hall_id, movie_id, start)
values ((select id from hall where name = 'Ролан'), (select id from movie where name = 'Звёздные войны XXIII: Атака клонированных клонов'), '10:00');

merge into app_option(_option, _value)
key(_option)
values ('IS_SALE_OPENED', 'true');

merge into booked_place(movie_show_id, hall_place_id, seance_date)
key(movie_show_id, hall_place_id)
values (
(select id from movie_show where hall_id = (select id from hall where name = 'Ролан')
and movie_id = (select id from movie where name = 'Звёздные войны XXIII: Атака клонированных клонов')
and start = '10:00'),
(select id from hall_place where hall_id = (select id from hall where name = 'Ролан')
and _row = 0 and _col = 0),
now());