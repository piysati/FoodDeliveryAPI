package com.bits_wilp.fooddeliveryapi.repository;

import com.bits_wilp.fooddeliveryapi.entity.MenuItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MenuItemRepo extends JpaRepository<MenuItems, Long> {


    // Find menu items by restaurant name
    @Query("SELECT m FROM MenuItems m WHERE m.restaurant.name = ?1")
    Optional<MenuItems> findMenuItemsByRestaurantName(String restaurantName);

    // Search menu items by name and description (cuisine type)
    @Query("SELECT m FROM MenuItems m WHERE m.item_name LIKE %:item_name% AND m.description LIKE %:description%")
    Optional<MenuItems> searchMenuItems(@Param("item_name") String item_name, @Param("description") String description);

}
