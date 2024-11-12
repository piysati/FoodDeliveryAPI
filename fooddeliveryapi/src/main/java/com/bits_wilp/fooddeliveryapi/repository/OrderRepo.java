package com.bits_wilp.fooddeliveryapi.repository;

import com.bits_wilp.fooddeliveryapi.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<Orders, Long> {
    List<Orders> findByCustomerId(Long customerId);
    List<Orders> findByRestaurantId(Long restaurantId);
    List<Orders> findByStatus(String status);
}
