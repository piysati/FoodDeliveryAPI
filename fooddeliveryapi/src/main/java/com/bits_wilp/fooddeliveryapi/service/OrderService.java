package com.bits_wilp.fooddeliveryapi.service;

import com.bits_wilp.fooddeliveryapi.dto.OrderDTO;
import com.bits_wilp.fooddeliveryapi.entity.Orders;

import java.util.List;

public interface OrderService {
    OrderDTO placeOrder(OrderDTO orderDTO);
    OrderDTO getOrderById(Long orderId);
    void cancelOrder(Long orderId);
    List<OrderDTO> getOrderHistory(Long customerId);

    List<Orders> getAllOrders();
    Orders updateOrderStatus(Long orderId, String status);
    void deleteOrder(Long orderId);
}
