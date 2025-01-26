package ru.gocinema.server.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gocinema.server.model.HallPlace;

@Repository
public interface HallPlaceRepository extends CrudRepository<HallPlace, Integer> {
    @Modifying
    @Query("delete from HallPlace p where p.hall.id = :hallId")
    void deleteAllByHallId(int hallId);
}
