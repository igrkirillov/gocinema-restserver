package ru.gocinema.server.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gocinema.server.model.MovieShowPlace;

@Repository
public interface MovieShowPlaceRepository extends CrudRepository<MovieShowPlace, Integer> {

}
