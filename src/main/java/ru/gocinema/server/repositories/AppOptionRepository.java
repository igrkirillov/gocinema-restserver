package ru.gocinema.server.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gocinema.server.model.AppOption;
import ru.gocinema.server.model.AppOption.Option;

@Repository
public interface AppOptionRepository extends CrudRepository<AppOption, Integer> {
    @Query("select e from AppOption e where e.option = :option")
    AppOption findByOption(Option option);
}
