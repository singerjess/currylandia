package com.currylandia.currylandia.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Restaurant {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Column
    private final String name;
    @NotNull
    @Column
    private final String description;
    @NotNull
    @Column
    private final String address;

    public Restaurant(String name, String description, String address) {
        this.name = name;
        this.description = description;
        this.address = address;
    }
//TODO: asdd schedule
}
