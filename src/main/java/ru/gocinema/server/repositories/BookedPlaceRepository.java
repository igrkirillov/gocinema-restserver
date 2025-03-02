package ru.gocinema.server.repositories;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gocinema.server.model.BookedPlace;

@Repository
public interface BookedPlaceRepository extends CrudRepository<BookedPlace, Integer> {

    @Query("select e from BookedPlace e where e.movieShow.id = :movieShowId and e.seanceDate = :seanceDate")
    List<BookedPlace> findByParameters(Integer movieShowId, LocalDate seanceDate);
}
