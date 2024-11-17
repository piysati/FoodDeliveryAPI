package com.bits_wilp.fooddeliveryapi.dto;

import com.bits_wilp.fooddeliveryapi.entity.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString // Generates a toString() method
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {

    private Long id;
    private Long userId;
    @NotBlank(message = "Restaurant id cannot be empty")
    private Long restaurantId;
    @NotBlank(message = "Menu items cannot be empty")
    private List<MenuItems> menuItems;
    private String status;  // Enum for status (PREPARING, OUT_FOR_DELIVERY, DELIVERED)
    private Long deliveryPartnerId;
    private double totalPrice;
    private LocalDateTime orderDateTime;

}
