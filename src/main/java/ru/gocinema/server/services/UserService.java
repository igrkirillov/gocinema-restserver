package ru.gocinema.server.services;

import java.util.List;
import ru.gocinema.restapi.model.User;
import ru.gocinema.restapi.model.UserParameters;

public interface UserService {
    List<User> getUsers();
    User saveUser(UserParameters parameters);
}
