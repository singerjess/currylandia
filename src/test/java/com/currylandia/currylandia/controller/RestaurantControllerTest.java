package com.currylandia.currylandia.controller;

import com.currylandia.currylandia.domain.Restaurant;
import com.currylandia.currylandia.service.RestaurantService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class RestaurantControllerTest {

    RestaurantController restaurantController;
    RestaurantService restaurantService;
    Restaurant restaurant1;

    @BeforeEach
    public void setUp() {
        restaurant1 = new Restaurant("pepe", "comida portenia", "chacarita 1234");
        restaurantService = mock(RestaurantService.class);
        restaurantController = new RestaurantController(restaurantService);
    }

    @Test
    public void listAllRestaurantsShouldRetrieveAllRestaurants() {
        List<Restaurant> expectedRestaurants = List.of(restaurant1);
        when(restaurantService.findAll()).thenReturn(expectedRestaurants);

        assertEquals(expectedRestaurants, restaurantController.findAll());
    }

    @Test
    public void addingARestaurantShouldAddItToTheService() {
        restaurantController.add(restaurant1);

        verify(restaurantService).save(eq(restaurant1));
    }
}