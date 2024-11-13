package com.bits_wilp.fooddeliveryapi.service;

import com.bits_wilp.fooddeliveryapi.entity.MenuItems;
import com.bits_wilp.fooddeliveryapi.entity.Orders;
import com.bits_wilp.fooddeliveryapi.entity.OrderStatus;
import com.bits_wilp.fooddeliveryapi.entity.Restaurant;
import com.bits_wilp.fooddeliveryapi.exceptions.ResourceNotFoundException;
import com.bits_wilp.fooddeliveryapi.repository.MenuItemRepo;
import com.bits_wilp.fooddeliveryapi.repository.OrderRepo;
import com.bits_wilp.fooddeliveryapi.repository.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService{

    @Autowired
    private RestaurantRepo restaurantRepository;

    @Autowired
    private MenuItemRepo menuItemRepo;

    @Autowired
    private OrderRepo orderRepo;

    @Override
    public List<Restaurant> getAllRestaurants() {
        return this.restaurantRepository.findAll();
    }








    @Override
    public MenuItems addMenuItem(Long restaurantId, MenuItems menuItem) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found"));
        menuItem.setRestaurant(restaurant);
        return menuItemRepo.save(menuItem);
    }

    @Override
    public MenuItems updateMenuItem(Long restaurantId, Long menuItemId, MenuItems menuItemDetails) {
        MenuItems menuItem = menuItemRepo.findById(menuItemId)
                .orElseThrow(() -> new ResourceNotFoundException("MenuItem not found"));
        if (!menuItem.getRestaurant().getId().equals(restaurantId)) {
            throw new IllegalArgumentException("MenuItem does not belong to the specified restaurant");
        }
        menuItem.setItem_name(menuItemDetails.getItem_name());
        menuItem.setPrice(menuItemDetails.getPrice());
        menuItem.setDescription(menuItemDetails.getDescription());
        return menuItemRepo.save(menuItem);
    }

    @Override
    public void deleteMenuItem(Long restaurantId, Long menuItemId) {
        MenuItems menuItem = menuItemRepo.findById(menuItemId)
                .orElseThrow(() -> new ResourceNotFoundException("MenuItem not found"));
        if (!menuItem.getRestaurant().getId().equals(restaurantId)) {
            throw new IllegalArgumentException("MenuItem does not belong to the specified restaurant");
        }
        menuItemRepo.delete(menuItem);
    }

    @Override
    public List<Orders> getOrders(Long restaurantId) {
        return orderRepo.findByRestaurantId(restaurantId);
    }

    @Override
    public Orders updateOrderStatus(Long restaurantId, Long orderId, String status) {
        Orders orders = orderRepo.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found"));
        if (!orders.getRestaurant().getId().equals(restaurantId)) {
            throw new IllegalArgumentException("Order does not belong to the specified restaurant");
        }
        orders.setStatus(OrderStatus.valueOf(status));
        return orderRepo.save(orders);
    }
}
