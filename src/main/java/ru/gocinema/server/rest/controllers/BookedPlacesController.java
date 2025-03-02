package ru.gocinema.server.rest.controllers;

import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.gocinema.restapi.BookedPlacesApi;
import ru.gocinema.restapi.model.BookedPlace;
import ru.gocinema.server.rest.services.BookedPlacesService;

@RestController
@RequiredArgsConstructor
public class BookedPlacesController implements BookedPlacesApi {

    private final BookedPlacesService bookedPlacesService;

    @Override
    public ResponseEntity<List<BookedPlace>> getBookedPlaces(Integer movieShowId, LocalDate date) {
        return ResponseEntity.ok(bookedPlacesService.getBookedPlaces(movieShowId, date));
    }
}
