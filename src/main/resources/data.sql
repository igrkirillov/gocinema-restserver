--наполняем базу для начального запуска

merge into _user(login, password, role)
key(login)
values ('admin', 'admin', 'ADMIN');

merge into _user(login, password, role)
key(login)
values ('customer', 'customer', 'CUSTOMER');

merge into hall(name, cols, rows)
key(name)
values ('Зал 1', 0, 0);

merge into hall(name, cols, rows)
key(name)
values ('Зал 2', 0, 0);
