package ru.gocinema.server.rest.services;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gocinema.restapi.model.Movie;
import ru.gocinema.restapi.model.MovieParameters;
import ru.gocinema.server.repositories.MovieRepository;
import ru.gocinema.server.rest.mappers.MovieMapper;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieMapper movieMapper;
    private final MovieRepository movieRepository;

    @Value("${posters.folder}")
    private String postersFolder;

    @Override
    public List<Movie> getMovies() {
        return movieMapper.map(movieRepository.findAll());
    }

    @Override
    public Movie saveMovie(MovieParameters parameters) {
        return movieMapper.map(movieRepository.save(movieMapper.map(parameters)));
    }

    @Transactional
    @Override
    public void updateMovie(int id, MovieParameters parameters) {
        ru.gocinema.server.model.Movie movie = movieRepository.findById(id).orElseThrow();
        movieMapper.fromDto(parameters, movie);
        movieRepository.save(movie);
    }

    @Transactional
    @Override
    public void savePoster(int id, String fileName, Resource resource) {
        String file = id + "-" + fileName;
        try {
            saveFileToPostersDirectory(file, resource);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        updatePosterUrl(id, file);
    }

    private void saveFileToPostersDirectory(String file, Resource resource) throws IOException {
        Path directory = Paths.get(postersFolder);
        if (!Files.exists(directory)) {
            Files.createDirectory(directory);
        }
        Path path = Files.createFile(directory.resolve(file));
        try (FileOutputStream outputStream = new FileOutputStream(path.toFile())) {
            IOUtils.copy(resource.getInputStream(), outputStream);
        }
    }

    private void updatePosterUrl(int id, String file) {
        ru.gocinema.server.model.Movie movie = movieRepository.findById(id).orElseThrow();
        movie.setPosterUrl("/" + postersFolder + "?fileName=" + file);
        movieRepository.save(movie);
    }
}
