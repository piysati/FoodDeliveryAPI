package com.bits_wilp.fooddeliveryapi.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Orders {
    //id, customer_id, restaurant_id, menu_items (list), status, delivery_person_id, total_price, order_date
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    private String restaurantId;
    private double totalPrice;
    private LocalDateTime orderDateTime;

//    @ManyToOne
//    @JoinColumn(name = "restaurant_id", nullable = false)
//    private Restaurant restaurant;

    @ManyToMany
    @JoinTable(
            name = "order_menu_items",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "menu_item_id"))
    private List<MenuItems> menuItems;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;  // Enum for status (PREPARING, OUT_FOR_DELIVERY, DELIVERED)

    @ManyToOne
    @JoinColumn(name = "delivery_person_id")
    private DeliveryPartner deliveryPartner;



    // getters and setters
}
