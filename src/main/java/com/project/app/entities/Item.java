package com.project.app.entities;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Entity(name = "items")
@Getter
@Setter
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    protected Integer id;
    protected String name;
    protected BigDecimal initialPrice;

    //this value can be null
    // in order to avoid null columns in our database we create a separate table to represent this value
    @ManyToOne
    @JoinTable(name = "item_buyers",
            joinColumns = @JoinColumn(name = "item_id"),
            inverseJoinColumns = @JoinColumn(nullable = false))
    protected User buyer;

    @ManyToOne(fetch = FetchType.LAZY)
    protected User seller;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    protected Category category;

    @Future
    @NotNull
    ZonedDateTime auctionEnd;

}
