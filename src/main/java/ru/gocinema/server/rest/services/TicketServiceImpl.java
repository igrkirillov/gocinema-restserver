package ru.gocinema.server.rest.services;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gocinema.restapi.model.BookingTicketParameters;
import ru.gocinema.restapi.model.Option;
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
    private final AppOptionService appOptionService;

    private static final String SALE_CLOSED_MESSAGE = "Продажи закрыты";
    private static final String PLACES_BOOKED_ALREADY = "Места уже забронены";
    private static final DateTimeFormatter QR_SEANCE_DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private static final DateTimeFormatter QR_SEANCE_TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

    @Transactional
    @Override
    public Ticket payTicket(Integer ticketId, PaymentTicketParameters parameters) {
        checkSaleOpened();
        ru.gocinema.server.model.Ticket ticket = ticketRepository.findById(ticketId).orElseThrow();
        ticket.setQrCode(generateQrCode(ticket));
        ticket.setPayed(true);
        ticket = ticketRepository.save(ticket);
        return ticketsMapper.map(ticket);
    }

    private String generateQrCode(ru.gocinema.server.model.Ticket ticket) {
        return String.join("; ",
                "QR код",
                "Фильм: " + ticket.getBookedPlaces().getFirst().getMovieShow().getMovie().getName(),
                "Зал: " + ticket.getBookedPlaces().getFirst().getMovieShow().getHall().getName(),
                "Дата сеанса: " + ticket.getBookedPlaces().getFirst().getSeanceDate().format(QR_SEANCE_DATE_FORMATTER),
                "Время сеанса: " + ticket.getBookedPlaces().getFirst().getMovieShow().getStart().format(QR_SEANCE_TIME_FORMATTER),
                "Места: " + ticket.getBookedPlaces().stream().map(p -> (p.getHallPlace().getRow()+1) + "-" + (p.getHallPlace().getCol()+1)).collect(
                        Collectors.joining("-")));
    }

    @Transactional
    @Override
    public Ticket bookTicket(BookingTicketParameters parameters) {
        checkSaleOpened();
        ru.gocinema.server.model.Ticket ticket = new ru.gocinema.server.model.Ticket();
        ticket.setUser(securityService.getCurrentUser());
        ticket.setPayed(false);

        MovieShow movieShow = movieShowRepository.findById(parameters.getMovieShowId()).orElseThrow();

        Set<Integer> placeIdsOfBooked = bookedPlaceRepository.findByParameters(movieShow.getId(),
                parameters.getSeanceDate()).stream().map(bp -> bp.getHallPlace().getId()).collect(
                Collectors.toSet());
        if (parameters.getPlaceIds().stream().anyMatch(placeIdsOfBooked::contains)) {
            throw new IllegalStateException(PLACES_BOOKED_ALREADY);
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

    private void checkSaleOpened() {
        boolean isSaleOpened = BooleanUtils.toBooleanObject(
                appOptionService.getAppOption(Option.IS_SALE_OPENED).getValue());
        if (!isSaleOpened) {
            throw new IllegalStateException(SALE_CLOSED_MESSAGE);
        }
    }
}
