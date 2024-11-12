package com.bits_wilp.fooddeliveryapi.service;

import com.bits_wilp.fooddeliveryapi.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private OrderRepo orderRepository;

    @Override
    public List<String> getPopularRestaurants() {
        // This could involve complex logic or a custom query to find the most popular restaurants.
        return List.of("Restaurant A", "Restaurant B", "Restaurant C");
    }

    @Override
    public double getAverageDeliveryTime() {
        // Sample average calculation
        return 30.5;
    }

    @Override
    public List<String> getOrderTrends() {
        // Sample order trends data
        return List.of("Increasing", "Stable", "Decreasing");
    }

    @Override
    public Map<String, Object> getPlatformActivity() {
        Map<String, Object> activityReport = new HashMap<>();
        activityReport.put("activeUsers", 100);
        activityReport.put("totalOrders", orderRepository.count());
        activityReport.put("completedOrders", orderRepository.count());
        return activityReport;
    }
}
