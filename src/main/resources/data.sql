--наполняем базу для начального запуска

merge into _user(login, password, role)
key(login)
values ('admin', 'admin', 'ADMIN');

merge into _user(login, password, role)
key(login)
values ('customer', 'customer', 'CUSTOMER');

merge into hall(name, cols, rows)
key(name)
values ('Зал 1', 2, 2);

merge into hall(name, cols, rows)
key(name)
values ('Зал 2', 0, 0);

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