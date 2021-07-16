package com.currylandia.currylandia.mapper;

import com.currylandia.currylandia.controller.domain.RestaurantDTO;
import com.currylandia.currylandia.domain.Restaurant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RestaurantMapperTest {

    private RestaurantMapper restaurantMapper;
    private RestaurantDTO restaurantDTO;
    private Restaurant restaurant;
    private final Long id = 1L;
    private final String address = "loyola 123";
    private final String description = "comida vegana";
    private final String name = "lo de ivan";

    @BeforeEach
    public void setUp() {
        restaurantDTO = new RestaurantDTO(id, name, description, address);
        restaurant = new Restaurant(id, name, description, address);
        restaurantMapper = new RestaurantMapper();
    }

    @Test
    public void mappingARestaurantDTOShouldReturnARestaurantWithCorrectName() {
        Restaurant actualRestaurant = restaurantMapper.mapToDomain(restaurantDTO);

        assertEquals(actualRestaurant.getName(), name);
    }
    @Test
    public void mappingARestaurantDTOShouldReturnARestaurantWithCorrectAddress() {
        Restaurant actualRestaurant = restaurantMapper.mapToDomain(restaurantDTO);

        assertEquals(actualRestaurant.getAddress(), address);
    }
    @Test
    public void mappingARestaurantDTOShouldReturnARestaurantWithCorrectDescription() {
        Restaurant actualRestaurant = restaurantMapper.mapToDomain(restaurantDTO);

        assertEquals(actualRestaurant.getDescription(), description);
    }
    @Test
    public void mappingARestaurantShouldReturnARestaurantDTOWithCorrectName() {
        RestaurantDTO actualRestaurantDTO = restaurantMapper.mapToDTO(restaurant);

        assertEquals(actualRestaurantDTO.getName(), name);
    }
    @Test
    public void mappingARestaurantShouldReturnARestaurantDTOWithCorrectAddress() {
        RestaurantDTO actualRestaurantDTO = restaurantMapper.mapToDTO(restaurant);

        assertEquals(actualRestaurantDTO.getAddress(), address);
    }
    @Test
    public void mappingARestaurantShouldReturnARestaurantDTOWithCorrectDescription() {
        RestaurantDTO actualRestaurantDTO = restaurantMapper.mapToDTO(restaurant);

        assertEquals(actualRestaurantDTO.getDescription(), description);
    }

}