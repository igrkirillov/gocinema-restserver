package ru.gocinema.rest.repositories.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * Кино-зал
 */
@Entity
@Table(name = "user")
@ToString
@EqualsAndHashCode(of = "id")
public class Hall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private int id;

    @Column
    private String name;

    @Column(name = "x_size")
    private int xSize;

    @Column(name = "y_size")
    private int ySize;
}
