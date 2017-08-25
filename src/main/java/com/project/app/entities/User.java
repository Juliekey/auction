package com.project.app.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "users")
@ToString(doNotUseGetters = true)
@Getter
@Setter
@EqualsAndHashCode
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    protected Long id;

    @NotNull
    @org.hibernate.validator.constraints.Email
    protected String email;

    protected String firstName;

    protected String lastName;

    @NotNull
    @Size(max = 60, min = 60, message = "Encoded password should be 60 characters length")
    protected String password;

    @Enumerated(EnumType.STRING)
    @NotNull
    protected Role role;

    @NotNull
    protected boolean enabled = true;

    public User(String email, String firstName, String lastName, String password, Role role) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.role = role;
    }

    @OneToMany(mappedBy = "buyer")
    protected Set<Item> boughtItems = new HashSet<>();

    @OneToMany(mappedBy = "seller")
    protected Set<Item> soldItems = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    Set<Bid> allBids;


}
