package com.currylandia.currylandia.controller;

import com.currylandia.currylandia.controller.domain.RestaurantDTO;
import com.currylandia.currylandia.domain.Restaurant;
import com.currylandia.currylandia.mapper.RestaurantMapper;
import com.currylandia.currylandia.service.RestaurantService;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
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

    @GetMapping("/restaurants/{restaurantId}")
    public RestaurantDTO getById(@PathVariable @NotBlank Long restaurantId) {
        return restaurantMapper.mapToDTO(restaurantService.getById(restaurantId));
    }


    @PostMapping("/add")
    public RestaurantDTO add(@RequestBody RestaurantDTO restaurant) {
        return restaurantMapper.mapToDTO(restaurantService.save(restaurantMapper.mapToDomain(restaurant)));
    }
}
