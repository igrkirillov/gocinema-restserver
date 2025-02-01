package ru.gocinema.server.rest.controllers;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.gocinema.restapi.HallPlacesApi;
import ru.gocinema.restapi.model.HallPlace;
import ru.gocinema.restapi.model.HallPlaceParameters;
import ru.gocinema.server.rest.services.HallPlaceService;

@RestController
@RequiredArgsConstructor
public class HallPlacesController implements HallPlacesApi {

    private final HallPlaceService hallPlaceService;

    @Override
    public ResponseEntity<List<HallPlace>> getHallPlaces(Integer hallId) {
        return ResponseEntity.ok(hallPlaceService.getHallPlaces(hallId));
    }

    @Override
    public ResponseEntity<Void> updateHallPlace(Integer id, HallPlaceParameters parameters) {
        hallPlaceService.updateHallPlace(id, parameters);
        return ResponseEntity.ok().build();
    }
}
