package com.bits_wilp.fooddeliveryapi.controllers;

import com.bits_wilp.fooddeliveryapi.entity.MenuItems;
import com.bits_wilp.fooddeliveryapi.entity.Orders;
import com.bits_wilp.fooddeliveryapi.entity.Restaurant;
import com.bits_wilp.fooddeliveryapi.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/")
    public ResponseEntity<List<Restaurant>> getAllRestaurants() {
        List<Restaurant> restaurants = restaurantService.getAllRestaurants();
        return ResponseEntity.ok(restaurants);
    }

    @GetMapping("/{restaurantName}/menu")
    public ResponseEntity<List<MenuItems>> getRestaurantMenu(@PathVariable String restaurantName) {
        List<MenuItems> menu = restaurantService.getRestaurantMenuByName(restaurantName);
        return ResponseEntity.ok(menu);
    }

    @GetMapping("/menu/search")
    public ResponseEntity<List<MenuItems>> searchMenuItems(
            @RequestParam String query,
            @RequestParam(required = false) String cuisine) {
        List<MenuItems> menuItems = restaurantService.searchMenuItems(query, cuisine);
        return ResponseEntity.ok(menuItems);
    }




    @PostMapping("/{restaurantId}/menu")
    public ResponseEntity<MenuItems> addMenuItem(@PathVariable Long restaurantId, @RequestBody MenuItems menuItem) {
        MenuItems createdMenuItem = restaurantService.addMenuItem(restaurantId, menuItem);
        return new ResponseEntity<>(createdMenuItem, HttpStatus.CREATED);
    }

    @PutMapping("/{restaurantId}/menu/{menuItemId}")
    public ResponseEntity<MenuItems> updateMenuItem(@PathVariable Long restaurantId, @PathVariable Long menuItemId,
                                                   @RequestBody MenuItems menuItem) {
        MenuItems updatedMenuItem = restaurantService.updateMenuItem(restaurantId, menuItemId, menuItem);
        return new ResponseEntity<>(updatedMenuItem, HttpStatus.OK);
    }

    @DeleteMapping("/{restaurantId}/menu/{menuItemId}")
    public ResponseEntity<Void> deleteMenuItem(@PathVariable Long restaurantId, @PathVariable Long menuItemId) {
        restaurantService.deleteMenuItem(restaurantId, menuItemId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{restaurantId}/orders")
    public ResponseEntity<List<Orders>> getOrders(@PathVariable Long restaurantId) {
        List<Orders> orders = restaurantService.getOrders(restaurantId);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @PutMapping("/{restaurantId}/orders/{orderId}")
    public ResponseEntity<Orders> updateOrderStatus(@PathVariable Long restaurantId, @PathVariable Long orderId,
                                                    @RequestParam String status) {
        Orders updatedOrders = restaurantService.updateOrderStatus(restaurantId, orderId, status);
        return new ResponseEntity<>(updatedOrders, HttpStatus.OK);
    }
}
