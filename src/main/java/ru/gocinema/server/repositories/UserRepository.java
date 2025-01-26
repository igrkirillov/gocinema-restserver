package ru.gocinema.server.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gocinema.server.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

}
