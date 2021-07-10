package com.currylandia.currylandia.controller;

import com.currylandia.currylandia.domain.Restaurant;
import com.currylandia.currylandia.repository.RestaurantRepository;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RestaurantControllerTest {

    RestaurantController restaurantController;
    RestaurantRepository restaurantRepository;
    Restaurant restaurant1;

    @BeforeEach
    public void setUp() {
        restaurant1 = new Restaurant("pepe", "comida portenia", "chacarita 1234", new ArrayList());
        restaurantRepository = mock(RestaurantRepository.class);
        restaurantController = new RestaurantController(restaurantRepository);
    }

    @Test
    public void listAllRestaurantsShouldRetrieveAllRestaurants() {
        List<Restaurant> expectedRestaurants = List.of(restaurant1);
        when(restaurantRepository.getAll()).thenReturn(expectedRestaurants);

        assertEquals(expectedRestaurants, restaurantController.getAll());
    }

    @Test
    public void addingARestaurantShouldAddItToTheRepository() {
        restaurantController.add(restaurant1);

        verify(restaurantRepository).add(eq(restaurant1));
    }
}