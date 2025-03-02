package ru.gocinema.server.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Забронированное место на кино-сеанс
 */
@Entity
@Table(name = "booked_place")
@ToString
@EqualsAndHashCode(of = "id")
@Getter
@Setter
public class BookedPlace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    // Ссылка на кино-сеанс
    @ManyToOne
    @JoinColumn(name = "movie_show_id")
    private MovieShow movieShow;

    // Ссылка на место в кино-зале
    @ManyToOne
    @JoinColumn(name = "hall_place_id")
    private HallPlace hallPlace;

    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;

    @Column(name = "seance_date")
    private LocalDate seanceDate;
}
