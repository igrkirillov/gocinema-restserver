package ru.gocinema.server.rest.services;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gocinema.restapi.model.Movie;
import ru.gocinema.restapi.model.MovieParameters;
import ru.gocinema.server.repositories.MovieRepository;
import ru.gocinema.server.rest.mappers.MovieMapper;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieMapper movieMapper;
    private final MovieRepository movieRepository;

    @Override
    public List<Movie> getMovies() {
        return movieMapper.map(movieRepository.findAll());
    }

    @Override
    public Movie saveMovie(MovieParameters parameters) {
        return movieMapper.map(movieRepository.save(movieMapper.map(parameters)));
    }

    @Transactional
    @Override
    public void updateMovie(int id, MovieParameters parameters) {
        ru.gocinema.server.model.Movie movie = movieRepository.findById(id).orElseThrow();
        movieMapper.fromDto(parameters, movie);
        movieRepository.save(movie);
    }
}
