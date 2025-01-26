package ru.gocinema.server.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gocinema.server.model.Movie;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Integer> {

}
