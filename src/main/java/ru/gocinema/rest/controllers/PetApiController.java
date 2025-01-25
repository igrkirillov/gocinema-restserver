package ru.gocinema.rest.controllers;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.gocinema.restapi.PetsApi;
import ru.gocinema.restapi.model.Pet;

@RestController
public class PetApiController implements PetsApi {

    @Override
    public ResponseEntity<List<Pet>> listPets(Integer limit) {
        return ResponseEntity.ok(List.of(new Pet(1L, "cat")));
    }
}
