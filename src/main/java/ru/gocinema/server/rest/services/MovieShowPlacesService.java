package ru.gocinema.server.rest.services;

import java.util.List;
import ru.gocinema.restapi.model.MovieShowPlace;

public interface MovieShowPlacesService {
    List<MovieShowPlace> getMovieShowPlaces(Integer hallId, Integer movieId);
    void book(int id);
    void cancelBook(int id);
}
