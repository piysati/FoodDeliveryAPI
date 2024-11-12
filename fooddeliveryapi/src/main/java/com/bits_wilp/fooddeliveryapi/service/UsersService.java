package com.bits_wilp.fooddeliveryapi.service;

import com.bits_wilp.fooddeliveryapi.dto.LoginDTO;
import com.bits_wilp.fooddeliveryapi.dto.UserDTO;
import com.bits_wilp.fooddeliveryapi.entity.Users;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UsersService {

    UserDTO createUser(UserDTO userDTO);
    void loginUser(LoginDTO loginDTO);
    UserDTO updateUser(UserDTO userdto, Long userId);
    UserDTO getUserById(Long userId);
    List<UserDTO> getAllUsers();
    //deactivateUSer
    void deleteUser(Long userId);
}
