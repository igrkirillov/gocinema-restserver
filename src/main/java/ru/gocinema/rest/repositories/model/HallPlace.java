package ru.gocinema.rest.repositories.model;

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
import lombok.ToString;

/**
 * Место в зале
 */
@Entity
@Table(name = "user")
@ToString
@EqualsAndHashCode(of = "id")
public class HallPlace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private int id;

    @ManyToOne
    @JoinColumn(name = "hall_id")
    private Hall hall;

    @Column(name = "x_value")
    private int xValue;

    @Column(name = "y_value")
    private int yValue;

    @Column(name = "is_vip")
    private boolean isVip;
}
