package com.bits_wilp.fooddeliveryapi.service;

import com.bits_wilp.fooddeliveryapi.dto.OrderDTO;
import com.bits_wilp.fooddeliveryapi.entity.Orders;
import com.bits_wilp.fooddeliveryapi.entity.OrderStatus;
import com.bits_wilp.fooddeliveryapi.exceptions.ResourceNotFoundException;
import com.bits_wilp.fooddeliveryapi.repository.OrderRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public OrderDTO placeOrder(OrderDTO orderDTO) {
        Orders orders = dtoToEntity(orderDTO);
        Orders ordersPlaced = this.orderRepo.save(orders);
        return entityToDTO(ordersPlaced);
    }

    @Override
    public OrderDTO getOrderById(Long orderId) {
        Orders orders = this.orderRepo.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        return entityToDTO(orders);
    }

    @Override
    public void cancelOrder(Long orderId) {
        Orders orders = this.orderRepo.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));
        orders.setStatus(OrderStatus.CANCELLED);
        this.orderRepo.save(orders);
    }

    @Override
    public List<OrderDTO> getOrderHistory(Long customerId) {
        List<Orders> ordersHistory = this.orderRepo.findByUserId(customerId);
        List<OrderDTO> orderHistoryDTO = ordersHistory.stream().map(or -> entityToDTO(or)).collect(Collectors.toList());
        return orderHistoryDTO;

    }

    @Override
    public List<Orders> getAllOrders() {
        return orderRepo.findAll();
    }

    @Override
    public Orders updateOrderStatus(Long orderId, String status) {
        Orders orders = orderRepo.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found"));
        orders.setStatus(OrderStatus.valueOf(status));
        return orderRepo.save(orders);
    }

    @Override
    public void deleteOrder(Long orderId) {
        Orders orders = orderRepo.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found"));
        orderRepo.delete(orders);
    }


    private Orders dtoToEntity(OrderDTO orderDTO){
        Orders orders = this.modelMapper.map(orderDTO, Orders.class);
        return orders;
    }

    private OrderDTO entityToDTO(Orders orders){
        OrderDTO orderDTO = this.modelMapper.map(orders, OrderDTO.class);
        return orderDTO;
    }
}
