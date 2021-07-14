package com.currylandia.currylandia.service;

import com.currylandia.currylandia.domain.Restaurant;
import com.currylandia.currylandia.repository.RestaurantRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private List<Restaurant> restaurants;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Transactional(readOnly = true)
    public List<Restaurant> findAll() {
        return restaurantRepository.findAll();
    }

    public Restaurant save(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }
}
