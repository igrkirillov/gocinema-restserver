package ru.gocinema.server.rest.mappers;

import org.mapstruct.Mapper;
import ru.gocinema.server.model.AppOption.Option;

@Mapper(componentModel = "spring")
public interface AppOptionMapper {

    Option map(ru.gocinema.restapi.model.Option source);
}
