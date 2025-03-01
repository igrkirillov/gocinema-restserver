package ru.gocinema.server.rest.mappers;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.gocinema.restapi.model.MovieShowPlace;

@Mapper(componentModel = "spring", uses = {MovieShowMapper.class, HallPlaceMapper.class, MovieMapper.class, HallMapper.class})
public interface MovieShowPlaceMapper {
    @Mapping(target = "isBooked", expression = "java(source.isBooked())")
    MovieShowPlace map(ru.gocinema.server.model.MovieShowPlace source);

    List<MovieShowPlace> map(Iterable<ru.gocinema.server.model.MovieShowPlace> source);
}
