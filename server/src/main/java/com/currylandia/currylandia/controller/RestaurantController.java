package com.currylandia.currylandia.controller;

import com.currylandia.currylandia.controller.domain.RestaurantDTO;
import com.currylandia.currylandia.domain.Restaurant;
import com.currylandia.currylandia.mapper.RestaurantMapper;
import com.currylandia.currylandia.service.RestaurantService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class RestaurantController {

    private RestaurantService restaurantService;
    private RestaurantMapper restaurantMapper;

    public RestaurantController(RestaurantService restaurantService, RestaurantMapper restaurantMapper) {
        this.restaurantMapper = restaurantMapper;
        this.restaurantService = restaurantService;
    }

    @GetMapping("/restaurants")
    public List<RestaurantDTO> findAll() {
        return restaurantService.findAll().stream().map(restaurant -> restaurantMapper.mapToDTO(restaurant)).collect(Collectors.toList());
    }


    @PostMapping("/add")
    public RestaurantDTO add(@RequestBody RestaurantDTO restaurant) {
        return restaurantMapper.mapToDTO(restaurantService.save(restaurantMapper.mapToDomain(restaurant)));
    }
}
