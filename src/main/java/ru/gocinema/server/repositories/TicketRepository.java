package ru.gocinema.server.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gocinema.server.model.Ticket;

@Repository
public interface TicketRepository extends CrudRepository<Ticket, Integer> {
    @Query("select t from Ticket t where t.user.id = :userId or :userId is null")
    List<Ticket> findByParameters(Integer userId);
}
