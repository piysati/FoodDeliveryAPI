package com.bits_wilp.fooddeliveryapi.entity;

public enum Role {
    //Customer, DeliveryPersonnel, Admin, RestaurantOwner
    CUSTOMER("CUSTOMER"), RESTAURANT_OWNER("RESTAURANT_OWNER"), DELIVERY_PERSONNEL("DELIVERY_PERSONNEL"), ADMINISTRATOR("ADMINISTRATOR");

    private final String role;

    Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
