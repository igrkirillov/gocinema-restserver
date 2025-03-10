package ru.gocinema.server.rest.controllers;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
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

    @Override
    public ResponseEntity<Void> savePoster(Integer id, String fileName, Resource body) {
        movieService.savePoster(id, fileName, body);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Movie> getMovie(Integer id) {
        return ResponseEntity.ok(movieService.getMovie(id));
    }
}
