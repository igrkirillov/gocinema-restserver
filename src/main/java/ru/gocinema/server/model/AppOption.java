package ru.gocinema.server.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Опции
 */
@Entity
@Table(name = "app_option")
@ToString
@EqualsAndHashCode(of = "id")
@Getter
@Setter
public class AppOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column(name = "_option")
    @Enumerated(EnumType.STRING)
    private Option option;

    @Column(name = "_value")
    private String value;

    public enum Option {
        IS_SALE_OPENED
    }
}
