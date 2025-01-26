package ru.gocinema.server.services;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gocinema.restapi.model.User;
import ru.gocinema.server.mappers.UserMapper;
import ru.gocinema.server.repositories.UserRepository;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        return userMapper.map(userRepository.findAll());
    }
}
