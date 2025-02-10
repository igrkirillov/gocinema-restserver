--наполняем базу для начального запуска

merge into _user(login, password, role)
key(login)
values ('admin', 'admin', 'ADMIN');

merge into _user(login, password, role)
key(login)
values ('customer', 'customer', 'CUSTOMER');

merge into hall(name, cols, rows, st_price, vip_price)
key(name)
values ('Зал 1', 2, 2, 100, 300);

merge into hall(name, cols, rows, st_price, vip_price)
key(name)
values ('Зал 2', 0, 0, 250, 550);

merge into hall_place(hall_id, _row, _col, is_vip, is_blocked)
key(hall_id, _row, _col)
values ((select id from hall where name = 'Зал 1'), 0, 0, true, false);

merge into hall_place(hall_id, _row, _col, is_vip, is_blocked)
key(hall_id, _row, _col)
values ((select id from hall where name = 'Зал 1'), 0, 1, false, true);

merge into hall_place(hall_id, _row, _col, is_vip, is_blocked)
key(hall_id, _row, _col)
values ((select id from hall where name = 'Зал 1'), 1, 0, false, false);

merge into hall_place(hall_id, _row, _col, is_vip, is_blocked)
key(hall_id, _row, _col)
values ((select id from hall where name = 'Зал 1'), 1, 1, false, false);

merge into movie(name, description, duration, country, release_date)
key(name)
values ('Звёздные войны XXIII: Атака клонированных клонов', 'Фильм о звёздных войнах. Фантастика.', 130, 'США', '1990-01-01');

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