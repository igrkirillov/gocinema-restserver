package ru.gocinema.server.rest.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.gocinema.restapi.PostersApi;

@RestController
@RequiredArgsConstructor
public class PostersController implements PostersApi {
    @Value("${posters.folder}")
    private String postersFolder;

    @Override
    public ResponseEntity<Resource> getPoster(String fileName) {
        return ResponseEntity.ok(new FileSystemResource(postersFolder + "/" + fileName));
    }
}
