package ru.gocinema.server.rest.mappers;

import java.util.List;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import ru.gocinema.restapi.model.Movie;
import ru.gocinema.restapi.model.MovieParameters;

@Mapper(componentModel = "spring")
public interface MovieMapper {

    Movie map(ru.gocinema.server.model.Movie source);

    List<Movie> map(Iterable<ru.gocinema.server.model.Movie> source);

    ru.gocinema.server.model.Movie map(MovieParameters parameters);

    @InheritInverseConfiguration
    void fromDto(MovieParameters parameters, @MappingTarget ru.gocinema.server.model.Movie entity);
}
