package com.currylandia.currylandia.controller;

import com.currylandia.currylandia.domain.Restaurant;
import com.currylandia.currylandia.service.RestaurantService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestaurantController {

    private RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping("/restaurantes")
    public List<Restaurant> findAll() {
        return restaurantService.findAll();
    }


    @PostMapping("/agregar")
    public Restaurant add(@RequestBody Restaurant restaurant) {
        return restaurantService.save(restaurant);
    }
}
