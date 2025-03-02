package ru.gocinema.server.rest.mappers;

import java.util.List;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import ru.gocinema.restapi.model.MovieShow;
import ru.gocinema.restapi.model.MovieShowParameters;

@Mapper(componentModel = "spring", uses = {HallMapper.class, MovieMapper.class})
public interface MovieShowMapper {
    MovieShow map(ru.gocinema.server.model.MovieShow source);

    List<MovieShow> map(Iterable<ru.gocinema.server.model.MovieShow> source);
    ru.gocinema.server.model.MovieShow map(MovieShowParameters parameters);

    @InheritInverseConfiguration
    void fromDto(MovieShowParameters parameters, @MappingTarget ru.gocinema.server.model.MovieShow entity);
}
