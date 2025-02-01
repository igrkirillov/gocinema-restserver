package ru.gocinema.server.rest.services;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gocinema.restapi.model.MovieShow;
import ru.gocinema.restapi.model.MovieShowParameters;
import ru.gocinema.server.repositories.MovieShowRepository;
import ru.gocinema.server.rest.mappers.MovieShowMapper;

@Service
@RequiredArgsConstructor
public class MovieShowsServiceImpl implements MovieShowsService {

    private final MovieShowRepository movieShowRepository;
    private final MovieShowMapper movieShowsMapper;

    @Override
    public List<MovieShow> getMovieShows(Integer hallId) {
        return movieShowsMapper.map(movieShowRepository.findByParameters(hallId));
    }

    @Override
    public MovieShow saveMovieShow(MovieShowParameters parameters) {
        return movieShowsMapper.map(movieShowRepository.save(movieShowsMapper.map(parameters)));
    }

    @Transactional
    @Override
    public void updateMovieShow(int id, MovieShowParameters parameters) {
        ru.gocinema.server.model.MovieShow movieShow = movieShowRepository.findById(id).orElseThrow();
        movieShowsMapper.fromDto(parameters, movieShow);
        movieShowRepository.save(movieShow);
    }
}
