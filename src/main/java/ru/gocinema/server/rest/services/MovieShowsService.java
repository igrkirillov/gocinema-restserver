package ru.gocinema.server.rest.services;

import java.util.List;
import ru.gocinema.restapi.model.MovieShow;
import ru.gocinema.restapi.model.MovieShowParameters;

public interface MovieShowsService {
    List<MovieShow> getMovieShows(Integer hallId);
    MovieShow getMovieShow(int id);
    MovieShow saveMovieShow(MovieShowParameters parameters);
    void updateMovieShow(int id, MovieShowParameters parameters);
    void deleteMovieShow(int id);
}
