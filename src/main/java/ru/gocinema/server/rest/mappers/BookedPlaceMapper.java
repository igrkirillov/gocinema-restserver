package ru.gocinema.server.rest.mappers;

import java.util.List;
import org.mapstruct.Mapper;
import ru.gocinema.server.model.BookedPlace;

@Mapper(componentModel = "spring", uses = {MovieShowMapper.class, HallPlaceMapper.class, MovieMapper.class, HallMapper.class})
public interface BookedPlaceMapper {
    ru.gocinema.restapi.model.BookedPlace map(BookedPlace source);

    List<ru.gocinema.restapi.model.BookedPlace> map(Iterable<BookedPlace> source);
}
