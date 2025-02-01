package ru.gocinema.server.rest.services;

import java.util.List;
import ru.gocinema.restapi.model.Ticket;

public interface TicketService {
    List<Ticket> getTickets(Integer userId);
    Ticket createTicket(int movieShowPlaceId);
}
