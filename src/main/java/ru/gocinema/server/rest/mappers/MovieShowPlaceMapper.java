package ru.gocinema.server.rest.mappers;

import java.util.List;
import org.mapstruct.Mapper;
import ru.gocinema.restapi.model.MovieShowPlace;

@Mapper(componentModel = "spring")
public interface MovieShowPlaceMapper {
    MovieShowPlace map(ru.gocinema.server.model.MovieShowPlace source);

    List<MovieShowPlace> map(Iterable<ru.gocinema.server.model.MovieShowPlace> source);
}
