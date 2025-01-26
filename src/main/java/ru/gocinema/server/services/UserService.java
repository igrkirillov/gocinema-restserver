package ru.gocinema.server.services;

import java.util.List;
import ru.gocinema.restapi.model.User;

public interface UserService {
    List<User> getUsers();
}
