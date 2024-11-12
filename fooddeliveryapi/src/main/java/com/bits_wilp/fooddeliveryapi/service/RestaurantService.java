package com.bits_wilp.fooddeliveryapi.service;

import com.bits_wilp.fooddeliveryapi.entity.MenuItems;
import com.bits_wilp.fooddeliveryapi.entity.Orders;
import com.bits_wilp.fooddeliveryapi.entity.Restaurant;

import java.util.List;

public interface RestaurantService {
    List<Restaurant> getAllRestaurants();
    List<MenuItems> getRestaurantMenuByName(String restaurantName);
    List<MenuItems> searchMenuItems(String keyword, String cuisineType);

    MenuItems addMenuItem(Long restaurantId, MenuItems menuItem);
    MenuItems updateMenuItem(Long restaurantId, Long menuItemId, MenuItems menuItem);
    void deleteMenuItem(Long restaurantId, Long menuItemId);

    List<Orders> getOrders(Long restaurantId);
    Orders updateOrderStatus(Long restaurantId, Long orderId, String status);
}
