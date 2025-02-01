package ru.gocinema.server.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Место на кино-сеансе
 */
@Entity
@Table(name = "movie_show_place")
@ToString
@EqualsAndHashCode(of = "id")
@Getter
@Setter
public class MovieShowPlace {
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

    // Забронировано ли место
    @Column(name = "is_booked")
    private boolean isBooked;
}
