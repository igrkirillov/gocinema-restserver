package ru.gocinema.server.rest.controllers;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.gocinema.restapi.HallsApi;
import ru.gocinema.restapi.model.Hall;
import ru.gocinema.restapi.model.HallConfigurationParameters;
import ru.gocinema.restapi.model.HallPricesParameters;
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
    public ResponseEntity<Hall> saveHall(HallConfigurationParameters hallParameters) {
        return ResponseEntity.ok(hallService.save(hallParameters));
    }

    @Override
    public ResponseEntity<Void> updateHallConfiguration(Integer id, HallConfigurationParameters hallParameters) {
        hallService.updateConfiguration(id, hallParameters);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> updateHallPrices(Integer id, HallPricesParameters hallParameters) {
        hallService.updatePrices(id, hallParameters);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> deleteHall(Integer id) {
        hallService.delete(id);
        return ResponseEntity.ok().build();
    }
}
