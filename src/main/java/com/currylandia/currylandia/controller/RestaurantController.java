package com.currylandia.currylandia.controller;

import com.currylandia.currylandia.domain.Restaurant;
import com.currylandia.currylandia.repository.RestaurantRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestaurantController {

    private RestaurantRepository restaurantRepository;

    public RestaurantController(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @GetMapping("/restaurantes")
    public List<Restaurant> getAll() {
        return restaurantRepository.getAll();
    }


    @PostMapping("/add")
    public Restaurant add(@RequestBody Restaurant restaurant) {
        return restaurantRepository.add(restaurant);
    }
}
