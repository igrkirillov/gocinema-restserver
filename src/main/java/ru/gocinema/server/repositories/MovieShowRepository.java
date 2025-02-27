package ru.gocinema.server.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gocinema.server.model.MovieShow;

@Repository
public interface MovieShowRepository extends CrudRepository<MovieShow, Integer> {
    @Query("select s from MovieShow s where s.hall.id = :hallId or :hallId is null")
    List<MovieShow> findByParameters(Integer hallId);

    @Modifying
    @Query("delete from MovieShow s where s.hall.id = :hallId")
    void deleteByHallId(int hallId);
}
