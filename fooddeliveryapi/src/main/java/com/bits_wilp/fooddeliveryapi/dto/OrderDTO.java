package com.bits_wilp.fooddeliveryapi.dto;

import com.bits_wilp.fooddeliveryapi.entity.*;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

public class OrderDTO {

    private Long id;
    private Long userId;
    private Long restaurantId;
    private List<MenuItems> menuItems;
    private String status;  // Enum for status (PREPARING, OUT_FOR_DELIVERY, DELIVERED)
    private Long deliveryPartnerId;
    private double totalPrice;
    private LocalDateTime orderDateTime;

}
