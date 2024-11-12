package com.bits_wilp.fooddeliveryapi.controllers;

import com.bits_wilp.fooddeliveryapi.dto.UserDTO;
import com.bits_wilp.fooddeliveryapi.service.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bits_wilp.fooddeliveryapi.entity.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UsersServiceImpl userService;

    @Autowired
    private OrderServiceImpl orderService;

    @Autowired
    private ReportServiceImpl reportService;

    // User Management
    @PostMapping("/users")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO user) {
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long userId) {
        return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.OK);
    }

    @PutMapping("/users/{userId}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long userId, @RequestBody UserDTO user) {
        return new ResponseEntity<>(userService.updateUser(user, userId), HttpStatus.OK);
    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity<Void> deactivateUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Order Management
    @GetMapping("/orders")
    public ResponseEntity<List<Orders>> getAllOrders() {
        return new ResponseEntity<>(orderService.getAllOrders(), HttpStatus.OK);
    }

    @PutMapping("/orders/{orderId}/status")
    public ResponseEntity<Orders> updateOrderStatus(@PathVariable Long orderId, @RequestParam String status) {
        return new ResponseEntity<>(orderService.updateOrderStatus(orderId, status), HttpStatus.OK);
    }

    @DeleteMapping("/orders/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long orderId) {
        orderService.deleteOrder(orderId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Reports & Monitoring
    @GetMapping("/reports/popular-restaurants")
    public ResponseEntity<List<String>> getPopularRestaurants() {
        return new ResponseEntity<>(reportService.getPopularRestaurants(), HttpStatus.OK);
    }

    @GetMapping("/reports/average-delivery-time")
    public ResponseEntity<Double> getAverageDeliveryTime() {
        return new ResponseEntity<>(reportService.getAverageDeliveryTime(), HttpStatus.OK);
    }

    @GetMapping("/reports/order-trends")
    public ResponseEntity<List<String>> getOrderTrends() {
        return new ResponseEntity<>(reportService.getOrderTrends(), HttpStatus.OK);
    }

    @GetMapping("/monitoring/platform-activity")
    public ResponseEntity<Map<String, Object>> getPlatformActivity() {
        return new ResponseEntity<>(reportService.getPlatformActivity(), HttpStatus.OK);
    }
}

