package ru.gocinema.server.rest.services;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gocinema.restapi.model.MovieShow;
import ru.gocinema.restapi.model.MovieShowParameters;
import ru.gocinema.server.model.BookedPlace;
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
        var movieShow = movieShowsMapper.map(parameters);
        movieShow.setHall(hallRepository.findById(parameters.getHallId()).orElseThrow());
        movieShow.setMovie(movieRepository.findById(parameters.getMovieId()).orElseThrow());
        movieShow.setPlaces(new ArrayList<>(createMovieShowPlaces(movieShow)));
        return movieShowsMapper.map(movieShowRepository.save(movieShow));
    }

    @Transactional
    @Override
    public void updateMovieShow(int id, MovieShowParameters parameters) {
        ru.gocinema.server.model.MovieShow movieShow = movieShowRepository.findById(id).orElseThrow();
        movieShowsMapper.fromDto(parameters, movieShow);
        movieShow.setHall(hallRepository.findById(parameters.getHallId()).orElseThrow());
        movieShow.setMovie(movieRepository.findById(parameters.getMovieId()).orElseThrow());
        movieShow.setPlaces(new ArrayList<>(createMovieShowPlaces(movieShow)));
        movieShowRepository.save(movieShow);
    }

    @Override
    public void deleteMovieShow(int id) {
        movieShowRepository.deleteById(id);
    }

    private List<BookedPlace> createMovieShowPlaces(ru.gocinema.server.model.MovieShow movieShow) {
        return movieShow.getHall().getPlaces().stream().map(hallPlace -> {
            BookedPlace place = new BookedPlace();
            place.setMovieShow(movieShow);
            place.setHallPlace(hallPlace);
            return place;
        }).toList();
    }

    @Override
    public MovieShow getMovieShow(int id) {
        return movieShowsMapper.map(movieShowRepository.findById(id).orElseThrow());
    }
}
