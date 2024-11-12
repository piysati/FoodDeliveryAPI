package com.bits_wilp.fooddeliveryapi.entity;

public enum OrderStatus {
//    PREPARING, OUT_FOR_DELIVERY, DELIVERED

    PREPARING("Preparing the order"),
    OUT_FOR_DELIVERY("Order is out for delivery"),
    DELIVERED("Order has been delivered"),
    CANCELLED("Order got cancelled");

    private final String orderStatus;

    OrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderStatus() {
        return orderStatus;
    }
}
