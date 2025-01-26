package ru.gocinema.server.rest.controllers;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.gocinema.restapi.HallsApi;
import ru.gocinema.restapi.model.Hall;
import ru.gocinema.restapi.model.HallParameters;
import ru.gocinema.server.rest.services.HallService;

@RestController
@RequiredArgsConstructor
public class HallsController implements HallsApi {

    private final HallService hallService;

    @Override
    public ResponseEntity<List<Hall>> getHalls() {
        return ResponseEntity.ok(hallService.getAll());
    }

    @Override
    public ResponseEntity<Hall> saveHall(HallParameters hallParameters) {
        return ResponseEntity.ok(hallService.save(hallParameters));
    }

    @Override
    public ResponseEntity<Void> updateHall(Integer id, HallParameters hallParameters) {
        hallService.update(id, hallParameters);
        return ResponseEntity.ok().build();
    }
}
