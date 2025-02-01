package ru.gocinema.server.rest.controllers;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.gocinema.restapi.MovieShowPlacesApi;
import ru.gocinema.restapi.model.MovieShowPlace;
import ru.gocinema.server.rest.services.MovieShowPlacesService;

@RestController
@RequiredArgsConstructor
public class MovieShowPlacesController implements MovieShowPlacesApi {

    private final MovieShowPlacesService movieShowPlacesService;

    @Override
    public ResponseEntity<List<MovieShowPlace>> getMovieShowPlaces(Integer hallId, Integer movieId) {
        return ResponseEntity.ok(movieShowPlacesService.getMovieShowPlaces(hallId, movieId));
    }

    @Override
    public ResponseEntity<Void> bookMovieShowPlace(Integer id) {
        movieShowPlacesService.book(id);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> cancelBookMovieShowPlace(Integer id) {
        movieShowPlacesService.cancelBook(id);
        return ResponseEntity.ok().build();
    }
}
