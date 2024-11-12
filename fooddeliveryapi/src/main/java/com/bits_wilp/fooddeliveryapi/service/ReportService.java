package com.bits_wilp.fooddeliveryapi.service;

import java.util.List;
import java.util.Map;

public interface ReportService {
    List<String> getPopularRestaurants();
    double getAverageDeliveryTime();
    List<String> getOrderTrends();
    Map<String, Object> getPlatformActivity();
}
