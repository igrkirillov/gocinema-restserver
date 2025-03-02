package ru.gocinema.server.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gocinema.server.model.Hall;
import ru.gocinema.server.model.HallPlace;

@Repository
public interface HallRepository extends CrudRepository<Hall, Integer> {
    @Query("select e from HallPlace e where e.id = :placeId")
    Optional<HallPlace> findByPlaceId(Integer placeId);
}
