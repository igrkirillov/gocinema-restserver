package ru.gocinema.server.rest.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.gocinema.restapi.AppOptionsApi;
import ru.gocinema.restapi.model.Option;
import ru.gocinema.server.rest.services.AppOptionService;

@RestController
@RequiredArgsConstructor
public class AppOptionsController implements AppOptionsApi {

    private final AppOptionService saleOptionService;

    @Override
    public ResponseEntity<String> getAppOption(Option option) {
        return ResponseEntity.ok(saleOptionService.getAppOption(option).getValue());
    }

    @Override
    public ResponseEntity<Void> saveAppOption(Option option, String value) {
        saleOptionService.saveAppOption(option, value);
        return ResponseEntity.ok().build();
    }
}
