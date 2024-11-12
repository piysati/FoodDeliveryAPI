package com.bits_wilp.fooddeliveryapi.service;

import com.bits_wilp.fooddeliveryapi.entity.Orders;

import java.util.List;

public interface DeliveryService {
    List<Orders> listAvailableOrders();
    Orders acceptOrderForDelivery(Long orderId, Long deliveryPartnerId);
    Orders updateDeliveryStatus(Long orderId, String status);
}
