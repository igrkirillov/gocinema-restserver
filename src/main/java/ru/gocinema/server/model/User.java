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
 * Пользователь системы. Имеет роль: {@link Role}.
 */
@Entity
@Table(name = "_user")
@ToString
@EqualsAndHashCode(of = "id")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    private String login;

    @Column
    private String password;

    @Column
    @Enumerated(EnumType.STRING)
    private Role role;

    public enum Role {
        ADMIN, CUSTOMER
    }
}
