package com.currylandia.currylandia.controller;

import com.currylandia.currylandia.controller.domain.RestaurantDTO;
import com.currylandia.currylandia.domain.Restaurant;
import com.currylandia.currylandia.mapper.RestaurantMapper;
import com.currylandia.currylandia.service.RestaurantService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class RestaurantControllerTest {

    private RestaurantController restaurantController;
    private RestaurantService restaurantService;
    private RestaurantDTO restaurantDTO;
    private RestaurantMapper restaurantMapper;
    private Restaurant restaurant;
    private final Long id = 1L;
    private final String name= "pepe";
    private final String description= "comida portenia";
    private final String address= "chacarita 1234";

    @BeforeEach
    public void setUp() {
        restaurantMapper = new RestaurantMapper();
        restaurantDTO = new RestaurantDTO(id, name, description, address);
        restaurant = new Restaurant(id, name, description, address);
        restaurantService = mock(RestaurantService.class);
        restaurantController = new RestaurantController(restaurantService, restaurantMapper);

    }

    @Test
    public void listAllRestaurantsShouldRetrieveAllRestaurants() {
        List<RestaurantDTO> expectedRestaurants = List.of(restaurantDTO);
        List<Restaurant> restaurants = List.of(restaurant);
        when(restaurantService.findAll()).thenReturn(restaurants);

        assertEquals(expectedRestaurants, restaurantController.findAll());
    }

    @Test
    public void addingARestaurantShouldAddItToTheService() {
        when(restaurantService.save(eq(restaurant))).thenReturn(restaurant);
        restaurantController.add(restaurantDTO);

        verify(restaurantService).save(eq(restaurantMapper.mapToDomain(restaurantDTO)));
    }

    @Test
    public void whenGettingARestaurantByIdThenAGetByIdShouldBeSentToTheService() {
        when(restaurantService.getById(eq(restaurant.getId()))).thenReturn(restaurant);
        restaurantController.getById(restaurantDTO.getId());

        verify(restaurantService).getById(eq(restaurantDTO.getId()));
    }
}