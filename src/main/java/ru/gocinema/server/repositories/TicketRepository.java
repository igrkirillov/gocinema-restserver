package ru.gocinema.server.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gocinema.server.model.Ticket;

@Repository
public interface TicketRepository extends CrudRepository<Ticket, Integer> {

}
