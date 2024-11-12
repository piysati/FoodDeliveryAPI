package com.bits_wilp.fooddeliveryapi.service;

import com.bits_wilp.fooddeliveryapi.entity.DeliveryPartner;
import com.bits_wilp.fooddeliveryapi.entity.Orders;
import com.bits_wilp.fooddeliveryapi.entity.OrderStatus;
import com.bits_wilp.fooddeliveryapi.exceptions.ResourceNotFoundException;
import com.bits_wilp.fooddeliveryapi.repository.DeliveryPartnerRepo;
import com.bits_wilp.fooddeliveryapi.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryServiceImpl implements DeliveryService{

    @Autowired
    private OrderRepo orderRepository;

    @Autowired
    private DeliveryPartnerRepo deliveryPartnerRepository;

    @Override
    public List<Orders> listAvailableOrders() {
        return orderRepository.findByStatus("Available");
    }

    @Override
    public Orders acceptOrderForDelivery(Long orderId, Long deliveryPartnerId) {
        Orders orders = orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found"));

        if (!"Available".equals(orders.getStatus())) {
            throw new IllegalArgumentException("Order is not available for delivery");
        }

        DeliveryPartner deliveryPartner = deliveryPartnerRepository.findById(deliveryPartnerId)
                .orElseThrow(() -> new ResourceNotFoundException("Delivery partner not found"));

        orders.setStatus(OrderStatus.valueOf("Accepted"));
        orders.setDeliveryPartner(deliveryPartner); // Assuming an Order has a DeliveryPartner field
        return orderRepository.save(orders);
    }

    @Override
    public Orders updateDeliveryStatus(Long orderId, String status) {
        Orders orders = orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found"));

        if (orders.getDeliveryPartner() == null) {
            throw new IllegalArgumentException("Order is not assigned to a delivery partner");
        }

        orders.setStatus(OrderStatus.valueOf(status));
        return orderRepository.save(orders);
    }
}
