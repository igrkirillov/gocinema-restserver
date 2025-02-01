package ru.gocinema.server.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gocinema.server.model.MovieShowPlace;

@Repository
public interface MovieShowPlaceRepository extends CrudRepository<MovieShowPlace, Integer> {

    @Query("select e from MovieShowPlace e where (e.hallPlace.hall.id = :hallId or :hallId is null) "
            + "or (e.movieShow.movie.id = :movieId or :movieId is null)")
    List<MovieShowPlace> findByParameters(Integer hallId, Integer movieId);
}
