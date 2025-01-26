package ru.gocinema.server.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gocinema.server.model.Hall;

@Repository
public interface HallRepository extends CrudRepository<Hall, Integer> {

}
