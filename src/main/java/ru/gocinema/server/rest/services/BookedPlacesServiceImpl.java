package ru.gocinema.server.rest.services;

import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gocinema.restapi.model.BookedPlace;
import ru.gocinema.server.repositories.BookedPlaceRepository;
import ru.gocinema.server.rest.mappers.BookedPlaceMapper;

@Service
@RequiredArgsConstructor
public class BookedPlacesServiceImpl implements BookedPlacesService {

    private final BookedPlaceRepository bookedPlaceRepository;
    private final BookedPlaceMapper bookedPlaceMapper;

    @Override
    public List<BookedPlace> getBookedPlaces(Integer movieShowId, LocalDate date) {
        return bookedPlaceMapper.map(bookedPlaceRepository.findByParameters(movieShowId, date));
    }
}
