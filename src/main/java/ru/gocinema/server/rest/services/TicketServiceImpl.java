package ru.gocinema.server.rest.services;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gocinema.restapi.model.Ticket;
import ru.gocinema.server.repositories.MovieShowPlaceRepository;
import ru.gocinema.server.repositories.TicketRepository;
import ru.gocinema.server.rest.mappers.TicketsMapper;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;
    private final TicketsMapper ticketsMapper;
    private final MovieShowPlaceRepository movieShowPlaceRepository;

    @Override
    public List<Ticket> getTickets(Integer userId) {
        return ticketsMapper.map(ticketRepository.findByParameters(userId));
    }

    @Override
    public Ticket createTicket(int movieShowPlaceId) {
        ru.gocinema.server.model.Ticket ticket = new ru.gocinema.server.model.Ticket();
        ticket.setUser(null);
        ticket.setQrCode("QR");
        ticket.setMovieShowPlace(movieShowPlaceRepository.findById(movieShowPlaceId).orElseThrow());
        return ticketsMapper.map(ticketRepository.save(ticket));
    }
}
