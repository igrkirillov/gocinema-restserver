package ru.gocinema.server.rest.services;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gocinema.restapi.model.MovieShowPlace;
import ru.gocinema.server.repositories.MovieShowPlaceRepository;
import ru.gocinema.server.rest.mappers.MovieShowPlaceMapper;

@Service
@RequiredArgsConstructor
public class MovieShowPlacesServiceImpl implements MovieShowPlacesService {

    private final MovieShowPlaceRepository movieShowPlaceRepository;
    private final MovieShowPlaceMapper movieShowPlaceMapper;

    @Override
    public List<MovieShowPlace> getMovieShowPlaces(Integer hallId, Integer movieId) {
        return movieShowPlaceMapper.map(movieShowPlaceRepository.findByParameters(hallId, movieId));
    }

    @Transactional
    @Override
    public void book(int id) {
        ru.gocinema.server.model.MovieShowPlace place = movieShowPlaceRepository.findById(id).orElseThrow();
        place.setBooked(true);
        movieShowPlaceRepository.save(place);
    }

    @Transactional
    @Override
    public void cancelBook(int id) {
        ru.gocinema.server.model.MovieShowPlace place = movieShowPlaceRepository.findById(id).orElseThrow();
        place.setBooked(false);
        movieShowPlaceRepository.save(place);
    }
}
