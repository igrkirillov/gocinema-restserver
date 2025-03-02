package ru.gocinema.server.rest.services;

import java.util.List;
import org.springframework.core.io.Resource;
import ru.gocinema.restapi.model.Movie;
import ru.gocinema.restapi.model.MovieParameters;

public interface MovieService {
    List<Movie> getMovies();
    Movie getMovie(int id);
    Movie saveMovie(MovieParameters parameters);
    void updateMovie(int id, MovieParameters parameters);
    void savePoster(int id, String fileName, Resource resource);
}
