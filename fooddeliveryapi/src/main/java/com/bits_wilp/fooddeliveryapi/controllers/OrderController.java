package com.bits_wilp.fooddeliveryapi.controllers;

import com.bits_wilp.fooddeliveryapi.dto.OrderDTO;
import com.bits_wilp.fooddeliveryapi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/order")
    public ResponseEntity<OrderDTO> placeOrder(@RequestBody OrderDTO order) {
        OrderDTO createdOrder = orderService.placeOrder(order);
        return new ResponseEntity(createdOrder, HttpStatus.CREATED);
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<OrderDTO> getOrderStatus(@PathVariable Long orderId) {
        //track order
        OrderDTO orderDTO = orderService.getOrderById(orderId);
        return new ResponseEntity(orderDTO, HttpStatus.OK);
    }

    @DeleteMapping("/order/{orderId}")
    public ResponseEntity<?> cancelOrder(@PathVariable Long orderId) {
        orderService.cancelOrder(orderId);
        return ResponseEntity.ok("Order canceled successfully");
    }

    @GetMapping("/orders")
    public ResponseEntity<List<OrderDTO>> getOrderHistory(@RequestParam Long customerId) {
        List<OrderDTO> orderHistory = orderService.getOrderHistory(customerId);
        return new ResponseEntity(orderHistory, HttpStatus.OK);
    }

}
