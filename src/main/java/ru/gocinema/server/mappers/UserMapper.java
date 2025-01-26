package ru.gocinema.server.mappers;

import java.util.List;
import org.mapstruct.Mapper;
import ru.gocinema.restapi.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User map(ru.gocinema.server.model.User source);
    List<User> map(Iterable<ru.gocinema.server.model.User> source);
}
