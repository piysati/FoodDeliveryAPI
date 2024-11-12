package com.bits_wilp.fooddeliveryapi.controllers;

import com.bits_wilp.fooddeliveryapi.entity.Orders;
import com.bits_wilp.fooddeliveryapi.service.DeliveryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class DeliveryController {
    @Autowired
    private DeliveryServiceImpl deliveryService;

    @GetMapping("/available")
    public ResponseEntity<List<Orders>> listAvailableOrders() {
        List<Orders> availableOrders = deliveryService.listAvailableOrders();
        return new ResponseEntity<>(availableOrders, HttpStatus.OK);
    }

    @PostMapping("/{orderId}/accept")
    public ResponseEntity<Orders> acceptOrderForDelivery(@PathVariable Long orderId,
                                                         @RequestParam Long deliveryPartnerId) {
        Orders acceptedOrders = deliveryService.acceptOrderForDelivery(orderId, deliveryPartnerId);
        return new ResponseEntity<>(acceptedOrders, HttpStatus.OK);
    }

    @PutMapping("/{orderId}/status")
    public ResponseEntity<Orders> updateDeliveryStatus(@PathVariable Long orderId,
                                                       @RequestParam String status) {
        Orders updatedOrders = deliveryService.updateDeliveryStatus(orderId, status);
        return new ResponseEntity<>(updatedOrders, HttpStatus.OK);
    }
}
