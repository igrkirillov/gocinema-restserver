package ru.gocinema.server.rest.services;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gocinema.restapi.model.MovieShow;
import ru.gocinema.restapi.model.MovieShowParameters;
import ru.gocinema.server.repositories.HallRepository;
import ru.gocinema.server.repositories.MovieRepository;
import ru.gocinema.server.repositories.MovieShowRepository;
import ru.gocinema.server.rest.mappers.MovieShowMapper;

@Service
@RequiredArgsConstructor
public class MovieShowsServiceImpl implements MovieShowsService {

    private final MovieShowMapper movieShowsMapper;
    private final HallRepository hallRepository;
    private final MovieRepository movieRepository;
    private final MovieShowRepository movieShowRepository;

    @Override
    public List<MovieShow> getMovieShows(Integer hallId) {
        return movieShowsMapper.map(movieShowRepository.findByParameters(hallId));
    }

    @Override
    public MovieShow saveMovieShow(MovieShowParameters parameters) {
        var seance = movieShowsMapper.map(parameters);
        seance.setHall(hallRepository.findById(parameters.getHallId()).orElseThrow());
        seance.setMovie(movieRepository.findById(parameters.getMovieId()).orElseThrow());
        return movieShowsMapper.map(movieShowRepository.save(seance));
    }

    @Transactional
    @Override
    public void updateMovieShow(int id, MovieShowParameters parameters) {
        ru.gocinema.server.model.MovieShow movieShow = movieShowRepository.findById(id).orElseThrow();
        movieShowsMapper.fromDto(parameters, movieShow);
        movieShow.setHall(hallRepository.findById(parameters.getHallId()).orElseThrow());
        movieShow.setMovie(movieRepository.findById(parameters.getMovieId()).orElseThrow());
        movieShowRepository.save(movieShow);
    }

    @Override
    public void deleteMovieShow(int id) {
        movieShowRepository.deleteById(id);
    }
}
