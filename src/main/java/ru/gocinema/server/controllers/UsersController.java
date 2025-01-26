package ru.gocinema.server.controllers;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.gocinema.restapi.UsersApi;
import ru.gocinema.restapi.model.User;
import ru.gocinema.server.services.UserService;

@RestController
@RequiredArgsConstructor
public class UsersController implements UsersApi {

    private final UserService userService;

    @Override
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }
}
