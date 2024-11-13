package com.bits_wilp.fooddeliveryapi.service;

import com.bits_wilp.fooddeliveryapi.entity.MenuItems;
import com.bits_wilp.fooddeliveryapi.repository.MenuItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuItemServiceImpl implements MenuItemService {

    @Autowired
    private MenuItemRepo menuItemRepo;

    @Override
    public Optional<MenuItems> getRestaurantMenuByName(String restaurantName) {
        return this.menuItemRepo.findMenuItemsByRestaurantName(restaurantName);
    }

    @Override
    public Optional<MenuItems> searchMenuItems(String keyword, String cuisineType) {
        return menuItemRepo.searchMenuItems(keyword, cuisineType);
    }
}
