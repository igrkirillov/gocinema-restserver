package ru.gocinema.server.rest.services;

import ru.gocinema.restapi.model.BookingTicketParameters;
import ru.gocinema.restapi.model.PaymentTicketParameters;
import ru.gocinema.restapi.model.Ticket;

public interface TicketService {
    Ticket payTicket(Integer ticketId, PaymentTicketParameters parameters);
    Ticket bookTicket(BookingTicketParameters parameters);
}
