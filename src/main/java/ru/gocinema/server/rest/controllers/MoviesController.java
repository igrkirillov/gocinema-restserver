package ru.gocinema.server.rest.controllers;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.gocinema.restapi.MoviesApi;
import ru.gocinema.restapi.model.Movie;
import ru.gocinema.restapi.model.MovieParameters;
import ru.gocinema.server.rest.services.MovieService;

@RestController
@RequiredArgsConstructor
public class MoviesController implements MoviesApi {

    private final MovieService movieService;

    @Override
    public ResponseEntity<List<Movie>> getMovies() {
        return ResponseEntity.ok(movieService.getMovies());
    }

    @Override
    public ResponseEntity<Movie> saveMovie(MovieParameters parameters) {
        return ResponseEntity.ok(movieService.saveMovie(parameters));
    }

    @Override
    public ResponseEntity<Void> updateMovie(Integer id, MovieParameters parameters) {
        movieService.updateMovie(id, parameters);
        return ResponseEntity.ok().build();
    }
}
