package com.currylandia.currylandia.controller.domain;


import javax.validation.constraints.NotBlank;
import java.util.Objects;

public class RestaurantDTO {

    @NotBlank(message = "Name is mandatory")
    private final String name;

    @NotBlank(message = "Description is mandatory")
    private final String description;

    @NotBlank(message = "Address is mandatory")
    private final String address;

    public RestaurantDTO(String name, String description, String address) {
        this.name = name;
        this.description = description;
        this.address = address;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RestaurantDTO that = (RestaurantDTO) o;
        return Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, address);
    }
}
