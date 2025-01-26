package ru.gocinema.server.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gocinema.server.model.MovieShow;

@Repository
public interface MovieShowRepository extends CrudRepository<MovieShow, Integer> {

}
