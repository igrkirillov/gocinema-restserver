package ru.gocinema.server;

import ru.gocinema.server.model.User;

public interface SecurityService {
    User getCurrentUser();
}
