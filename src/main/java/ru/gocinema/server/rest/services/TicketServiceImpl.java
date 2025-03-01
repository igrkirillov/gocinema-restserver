package ru.gocinema.server.rest.services;

import jakarta.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gocinema.restapi.model.BookingTicketParameters;
import ru.gocinema.restapi.model.PaymentTicketParameters;
import ru.gocinema.restapi.model.Ticket;
import ru.gocinema.server.SecurityService;
import ru.gocinema.server.model.MovieShowPlace;
import ru.gocinema.server.repositories.MovieShowPlaceRepository;
import ru.gocinema.server.repositories.TicketRepository;
import ru.gocinema.server.rest.mappers.TicketsMapper;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;
    private final TicketsMapper ticketsMapper;
    private final MovieShowPlaceRepository movieShowPlaceRepository;
    private final SecurityService securityService;
    private final EntityManager em;

    @Transactional
    @Override
    public Ticket payTicket(Integer ticketId, PaymentTicketParameters parameters) {
        ru.gocinema.server.model.Ticket ticket = ticketRepository.findById(ticketId).orElseThrow();
        ticket.setQrCode("QR");
        ticket.setPayed(true);
        ticket = ticketRepository.save(ticket);
        return ticketsMapper.map(ticket);
    }

    @Transactional
    @Override
    public Ticket bookTicket(BookingTicketParameters parameters) {
        ru.gocinema.server.model.Ticket ticket = new ru.gocinema.server.model.Ticket();
        ticket.setUser(securityService.getCurrentUser());
        ticket.setPayed(false);

        List<MovieShowPlace> places = parameters.getMovieShowPlaceIds().stream()
                .map(movieShowPlaceRepository::findById)
                .map(Optional::orElseThrow)
                .collect(Collectors.toList());
        if (places.stream().anyMatch(MovieShowPlace::isBooked)) {
            throw new IllegalStateException("Места уже забронены");
        }
        places.forEach(p -> {
            p.setBooked(true);
        });
        movieShowPlaceRepository.saveAll(places);

        ticket.setMovieShowPlaces(places);

        return ticketsMapper.map(ticketRepository.save(ticket));
    }
}
