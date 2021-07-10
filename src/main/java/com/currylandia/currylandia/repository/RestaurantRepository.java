package com.currylandia.currylandia.repository;

import com.currylandia.currylandia.domain.Restaurant;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RestaurantRepository {
    List<Restaurant> restaurants;

    public RestaurantRepository(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    public List<Restaurant> getAll() {
        return null;
    }

    public Restaurant add(Restaurant restaurant) {
        return restaurant;
    }
}
