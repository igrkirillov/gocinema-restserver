merge into _user(login, password, role)
key(login)
values ('admin', 'admin', 'ADMIN');

merge into _user(login, password, role)
key(login)
values ('customer', 'customer', 'CUSTOMER');