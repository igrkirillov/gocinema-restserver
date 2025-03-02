package ru.gocinema.server.rest.services;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gocinema.restapi.model.BookingTicketParameters;
import ru.gocinema.restapi.model.PaymentTicketParameters;
import ru.gocinema.restapi.model.Ticket;
import ru.gocinema.server.SecurityService;
import ru.gocinema.server.model.BookedPlace;
import ru.gocinema.server.model.MovieShow;
import ru.gocinema.server.repositories.BookedPlaceRepository;
import ru.gocinema.server.repositories.HallRepository;
import ru.gocinema.server.repositories.MovieShowRepository;
import ru.gocinema.server.repositories.TicketRepository;
import ru.gocinema.server.rest.mappers.TicketsMapper;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;
    private final TicketsMapper ticketsMapper;
    private final BookedPlaceRepository bookedPlaceRepository;
    private final SecurityService securityService;
    private final MovieShowRepository movieShowRepository;
    private final HallRepository hallRepository;

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

        MovieShow movieShow = movieShowRepository.findById(parameters.getMovieShowId()).orElseThrow();

        Set<Integer> placeIdsOfBooked = bookedPlaceRepository.findByParameters(movieShow.getId(),
                parameters.getSeanceDate()).stream().map(bp -> bp.getHallPlace().getId()).collect(
                Collectors.toSet());
        if (parameters.getPlaceIds().stream().anyMatch(placeIdsOfBooked::contains)) {
            throw new IllegalStateException("Места уже забронены");
        }

        List<BookedPlace> bookedPlaces = parameters.getPlaceIds().stream().map(plId -> {
            BookedPlace place = new BookedPlace();
            place.setHallPlace(hallRepository.findByPlaceId(plId).orElseThrow());
            place.setMovieShow(movieShow);
            place.setSeanceDate(parameters.getSeanceDate());
            return place;
        }).toList();
        bookedPlaceRepository.saveAll(bookedPlaces);

        ticket.setBookedPlaces(bookedPlaces);

        return ticketsMapper.map(ticketRepository.save(ticket));
    }
}
