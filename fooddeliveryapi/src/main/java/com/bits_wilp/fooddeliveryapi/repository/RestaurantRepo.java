package com.bits_wilp.fooddeliveryapi.repository;

import com.bits_wilp.fooddeliveryapi.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepo extends JpaRepository<Restaurant, Long> {
//    @Query("SELECT m FROM menu_items m WHERE m.restaurant.name = ?1")
//    List<MenuItems> findMenuItemsByRestaurantName(String restaurantName);
//    @Query("SELECT DISTINCT m FROM MenuItem m JOIN m.restaurant r WHERE m.name LIKE %?1% OR r.cuisineType LIKE %?2%")
//    @Query("SELECT m FROM Restaurant r JOIN r.menuItems m WHERE m.name LIKE %:name% AND m.category LIKE %:cuisine%")
//    List<MenuItems> searchMenuItems(String name, String cuisine);


}
