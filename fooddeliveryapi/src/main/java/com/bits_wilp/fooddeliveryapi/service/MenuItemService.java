package com.bits_wilp.fooddeliveryapi.service;

import com.bits_wilp.fooddeliveryapi.entity.MenuItems;

import java.util.Optional;

public interface MenuItemService {
    Optional<MenuItems> getRestaurantMenuByName(String restaurantName);
    Optional<MenuItems> searchMenuItems(String keyword, String cuisineType);
}
