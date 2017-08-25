package com.project.app.entities;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

/**
 * This class defines category for {@link Item} objects
 */

@Entity(name = "categories")
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    protected Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    protected Category parentCategory;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parentCategory")
    Set<Category> categories = new HashSet<>();

    @NotNull
    @Size(min = 2, max = 30)
    protected String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    Set<Item> items = new HashSet<>();
}
