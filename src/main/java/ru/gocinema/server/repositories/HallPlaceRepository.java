package ru.gocinema.server.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gocinema.server.model.HallPlace;

@Repository
public interface HallPlaceRepository extends CrudRepository<HallPlace, Integer> {

}
