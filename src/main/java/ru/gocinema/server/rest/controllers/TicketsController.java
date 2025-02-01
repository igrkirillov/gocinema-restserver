package ru.gocinema.server.rest.controllers;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.gocinema.restapi.TicketsApi;
import ru.gocinema.restapi.model.Ticket;
import ru.gocinema.restapi.model.TicketParameters;
import ru.gocinema.server.rest.services.TicketService;

@RestController
@RequiredArgsConstructor
public class TicketsController implements TicketsApi {

    private final TicketService ticketService;

    @Override
    public ResponseEntity<List<Ticket>> getTickets(Integer userId) {
        return ResponseEntity.ok(ticketService.getTickets(userId));
    }

    @Override
    public ResponseEntity<Ticket> saveTicket(TicketParameters ticketParameters) {
        return ResponseEntity.ok(ticketService.createTicket(ticketParameters.getMovieShowPlaceId()));
    }
}
