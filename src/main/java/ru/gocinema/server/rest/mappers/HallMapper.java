package ru.gocinema.server.rest.mappers;

import java.util.List;
import org.mapstruct.Mapper;
import ru.gocinema.restapi.model.Hall;
import ru.gocinema.restapi.model.HallParameters;

@Mapper(componentModel = "spring")
public interface HallMapper {

    Hall map(ru.gocinema.server.model.Hall source);

    List<Hall> map(Iterable<ru.gocinema.server.model.Hall> source);

    ru.gocinema.server.model.Hall map(HallParameters parameters);
}
