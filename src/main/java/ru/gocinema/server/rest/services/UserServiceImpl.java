package ru.gocinema.server.rest.services;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gocinema.restapi.model.User;
import ru.gocinema.restapi.model.UserParameters;
import ru.gocinema.server.rest.mappers.UserMapper;
import ru.gocinema.server.repositories.UserRepository;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final PasswordService passwordService;

    @Override
    public List<User> getUsers() {
        return userMapper.map(userRepository.findAll());
    }

    @Override
    public User saveUser(UserParameters parameters) {
        var userToSave = userMapper.map(parameters);
        userToSave.setPassword(passwordService.sign(parameters.getPassword()));
        return userMapper.map(userRepository.save(userToSave));
    }
}
