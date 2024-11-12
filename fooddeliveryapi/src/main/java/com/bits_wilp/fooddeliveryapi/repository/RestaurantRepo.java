package com.bits_wilp.fooddeliveryapi.repository;

import com.bits_wilp.fooddeliveryapi.entity.MenuItems;
import com.bits_wilp.fooddeliveryapi.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepo extends JpaRepository<Restaurant, Long> {
    @Query("SELECT m FROM MenuItem m WHERE m.restaurant.name = ?1")
    List<MenuItems> findMenuItemsByRestaurantName(String restaurantName);
    @Query("SELECT DISTINCT m FROM MenuItem m JOIN m.restaurant r WHERE m.name LIKE %?1% OR r.cuisineType LIKE %?2%")
    List<MenuItems> searchMenuItems(String keyword, String cuisineType);
}
