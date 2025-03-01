package ru.gocinema.server.rest.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.gocinema.restapi.TicketsApi;
import ru.gocinema.restapi.model.BookingTicketParameters;
import ru.gocinema.restapi.model.PaymentTicketParameters;
import ru.gocinema.restapi.model.Ticket;
import ru.gocinema.server.rest.services.TicketService;

@RestController
@RequiredArgsConstructor
public class TicketsController implements TicketsApi {

    private final TicketService ticketService;

    @Override
    public ResponseEntity<Ticket> bookTicket(BookingTicketParameters bookingTicketParameters) {
        return ResponseEntity.ok(ticketService.bookTicket(bookingTicketParameters));
    }

    @Override
    public ResponseEntity<Ticket> payTicket(Integer id, PaymentTicketParameters paymentTicketParameters) {
        return ResponseEntity.ok(ticketService.payTicket(id, paymentTicketParameters));
    }
}
