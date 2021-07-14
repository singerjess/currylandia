package com.currylandia.currylandia.mapper;

import com.currylandia.currylandia.controller.domain.RestaurantDTO;
import com.currylandia.currylandia.domain.Restaurant;
import org.springframework.stereotype.Component;

@Component
public class RestaurantMapper {
    public Restaurant mapToDomain(RestaurantDTO restaurantDTO) {
        return new Restaurant(restaurantDTO.getName(), restaurantDTO.getDescription(), restaurantDTO.getAddress());
    }

    public RestaurantDTO mapToDTO(Restaurant restaurant) {
        return new RestaurantDTO(restaurant.getName(), restaurant.getDescription(), restaurant.getAddress());
    }
}
