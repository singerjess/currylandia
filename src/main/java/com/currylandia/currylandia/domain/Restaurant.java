package com.currylandia.currylandia.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "restaurants")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Column
    private String name;

    @NotNull
    @Column
    private String description;

    @NotNull
    @Column
    private String address;

    public Restaurant(String name, String description, String address) {
        this.name = name;
        this.description = description;
        this.address = address;
    }

    public Restaurant() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getAddress() {
        return address;
    }
//TODO: asdd schedule
}
