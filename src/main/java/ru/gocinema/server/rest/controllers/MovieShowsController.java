package ru.gocinema.server.rest.controllers;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.gocinema.restapi.MovieShowsApi;
import ru.gocinema.restapi.model.MovieShow;
import ru.gocinema.restapi.model.MovieShowParameters;
import ru.gocinema.server.rest.services.MovieShowsService;

@RestController
@RequiredArgsConstructor
public class MovieShowsController implements MovieShowsApi {

    private final MovieShowsService movieShowsService;

    @Override
    public ResponseEntity<List<MovieShow>> getMovieShows(Integer hallId) {
        return ResponseEntity.ok(movieShowsService.getMovieShows(hallId));
    }

    @Override
    public ResponseEntity<MovieShow> saveMovieShow(MovieShowParameters parameters) {
        return ResponseEntity.ok(movieShowsService.saveMovieShow(parameters));
    }

    @Override
    public ResponseEntity<Void> updateMovieShow(Integer id, MovieShowParameters parameters) {
        movieShowsService.updateMovieShow(id, parameters);
        return ResponseEntity.ok().build();
    }
}
