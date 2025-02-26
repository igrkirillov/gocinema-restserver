package ru.gocinema.server.rest.controllers;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.gocinema.restapi.UsersApi;
import ru.gocinema.restapi.model.User;
import ru.gocinema.restapi.model.UserParameters;
import ru.gocinema.server.rest.services.UserService;

@RestController
@RequiredArgsConstructor
public class UsersController implements UsersApi {

    private final UserService userService;

    @Override
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }

    @Override
    public ResponseEntity<User> saveUser(UserParameters userParameters) {
        return ResponseEntity.ok(userService.saveUser(userParameters));
    }

    @Override
    public ResponseEntity<User> getUserByLogin(String login) {
        return ResponseEntity.ok(userService.getUserByLogin(login));
    }
}
