package ru.gocinema.server.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "user")
@ToString
@EqualsAndHashCode(of = "id")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String login;

    @Column
    private String password;

    @Column
    private Role role;

    public enum Role {
        ADMIN, CUSTOMER
    }
}
