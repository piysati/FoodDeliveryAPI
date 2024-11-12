package com.bits_wilp.fooddeliveryapi.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "Restaurant name cannot be empty")
    private String name;

    @Column(nullable = false)
    @NotBlank(message = "Address cannot be empty")
    private String address;

    @Column(nullable = false)
    @NotBlank(message = "Opening hours cannot be empty")
    private LocalTime opensAt;

    @Column(nullable = false)
    @NotBlank(message = "Closing hours cannot be empty")
    private LocalTime closesAt;

    private String cuisine;

    private String contactHour;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<MenuItems> menuItems;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<Orders> orders;

//    private String delivery_zone;

//    @ManyToOne
//    @JoinColumn(name = "owner_id", nullable = false)
//    private RestaurantOwner owner;

}