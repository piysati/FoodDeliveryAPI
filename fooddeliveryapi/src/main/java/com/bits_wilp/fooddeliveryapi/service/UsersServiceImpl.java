package com.bits_wilp.fooddeliveryapi.service;

import com.bits_wilp.fooddeliveryapi.dto.LoginDTO;
import com.bits_wilp.fooddeliveryapi.dto.UserDTO;
import com.bits_wilp.fooddeliveryapi.entity.Users;
import com.bits_wilp.fooddeliveryapi.exceptions.ResourceDuplicateException;
import com.bits_wilp.fooddeliveryapi.exceptions.ResourceNotFoundException;
import com.bits_wilp.fooddeliveryapi.exceptions.UserNotFound;
import com.bits_wilp.fooddeliveryapi.repository.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsersServiceImpl implements UsersService{

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        Users user = dtoToEntity(userDTO);
        if (this.userRepo.findByEmail(userDTO.getEmail()) != null) {
            throw new ResourceDuplicateException("Username already taken.");
        }
        Users savedUser = this.userRepo.save(user);
        return entityToDTO(savedUser);
    }

    @Override
    public void loginUser(LoginDTO loginDTO) {
        Users user = this.userRepo.findByEmail(loginDTO.getEmail()).orElseThrow(() -> new UserNotFound("User", "id", loginDTO.getEmail()));

//        Customer customer = customerRepository.findByEmail(loginDTO.getEmail());
        if (user == null || loginDTO.getPassword().equals(user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }
        // Generate token or return success message

    }

    @Override
    public UserDTO updateUser(UserDTO userdto, Long userId) {
        Users user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));


        user.setName(userdto.getName());
        user.setEmail(userdto.getEmail());
        user.setAbout(userdto.getAbout());
        user.setDeliveryAddress(userdto.getDeliveryAddress());
        user.setPassword(userdto.getPassword());

        Users updatedUser = this.userRepo.save(user);
        return entityToDTO(updatedUser);
    }

    @Override
    public UserDTO getUserById(Long userId) {
        Users user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        return entityToDTO(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<Users> allUsers = this.userRepo.findAll();
        List<UserDTO> listUserDTO = allUsers.stream().map(u -> entityToDTO(u)).collect(Collectors.toList());
        return listUserDTO;
    }

    @Override
    public void deleteUser(Long userId) {
        Users user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        this.userRepo.delete(user);
    }

    private Users dtoToEntity(UserDTO userdto){
//        Users user = new Users();
//        user.setId(userdto.getId());
//        user.setName(userdto.getName());
//        user.setEmail(userdto.getEmail());
//        user.setPassword(userdto.getPassword());
//        user.setAbout(userdto.getAbout());

        Users user = this.modelMapper.map(userdto, Users.class);
        return user;
    }

    private UserDTO entityToDTO(Users user){
//        UserDTO userDTO = new UserDTO();
//        userDTO.setId(user.getId());
//        userDTO.setName(user.getName());
//        userDTO.setEmail(user.getEmail());
//        userDTO.setPassword(user.getPassword());
//        userDTO.setAbout(user.getAbout());
        UserDTO userDTO = this.modelMapper.map(user, UserDTO.class);

        return userDTO;
    }
}
