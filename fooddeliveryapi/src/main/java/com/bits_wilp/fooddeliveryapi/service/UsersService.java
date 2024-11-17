package com.bits_wilp.fooddeliveryapi.service;

import com.bits_wilp.fooddeliveryapi.dto.LoginDTO;
import com.bits_wilp.fooddeliveryapi.dto.UserDTO;

import java.util.List;

public interface UsersService {

    UserDTO createUser(UserDTO userDTO);
    void loginUser(LoginDTO loginDTO);
    UserDTO updateUser(UserDTO userdto, Long userId);
    UserDTO getUserById(Long userId);
    UserDTO getUserByEmail(String email);
    List<UserDTO> getAllUsers();
    //deactivateUSer
    void deleteUser(Long userId);
}
