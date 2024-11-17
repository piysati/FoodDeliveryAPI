package com.bits_wilp.fooddeliveryapi.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity @Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryPartner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String name;
    @Column(nullable = false, unique = true)
    private String email;
    //encrypt this
    @Column(nullable = false)
    private String password;
    private String about;
    private String vehicleType;
    //    @OneToMany(mappedBy = "delivery_partner")
    //    private List<Order> orders;

//    contact
//    availability (Boolean)
//    vehicleType (String)

}
