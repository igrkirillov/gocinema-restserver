package ru.gocinema.server.rest.services;

import java.util.List;
import ru.gocinema.restapi.model.Movie;
import ru.gocinema.restapi.model.MovieParameters;

public interface MovieService {
    List<Movie> getMovies();
    Movie saveMovie(MovieParameters parameters);
    void updateMovie(int id, MovieParameters parameters);
}
