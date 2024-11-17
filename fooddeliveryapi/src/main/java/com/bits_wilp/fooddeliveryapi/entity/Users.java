package com.bits_wilp.fooddeliveryapi.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;


@Entity
@Table(name = "users")
@Data @NoArgsConstructor @AllArgsConstructor @Getter @Setter
@Inheritance(strategy = InheritanceType.JOINED)
public class Users implements UserDetails {

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
    private String deliveryAddress;
    private String paymentDetails;
    @OneToMany
            //(mappedBy = "customer")
    private List<Orders> orders;

    @Enumerated(EnumType.STRING)
    private Role role;                      // Enum for user roles (Customer, Owner, Delivery, Admin)

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.getRole()));
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
//                UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
//        UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
//        UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return true;
//        UserDetails.super.isEnabled();
    }
}
