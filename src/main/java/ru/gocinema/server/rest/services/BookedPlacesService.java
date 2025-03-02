package ru.gocinema.server.rest.services;

import java.time.LocalDate;
import java.util.List;
import ru.gocinema.restapi.model.BookedPlace;

public interface BookedPlacesService {
    List<BookedPlace> getBookedPlaces(Integer movieShowId, LocalDate date);
}
