package com.currylandia.currylandia.repository;

import com.currylandia.currylandia.domain.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
