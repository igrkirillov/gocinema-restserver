package ru.gocinema.server.rest.mappers;

import java.util.List;
import org.mapstruct.Mapper;
import ru.gocinema.restapi.model.HallPlace;

@Mapper(componentModel = "spring")
public interface HallPlaceMapper {

    HallPlace map(ru.gocinema.server.model.HallPlace source);

    List<HallPlace> map(Iterable<ru.gocinema.server.model.HallPlace> source);
}
