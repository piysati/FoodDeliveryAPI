package com.bits_wilp.fooddeliveryapi.controllers;

import com.bits_wilp.fooddeliveryapi.dto.LoginDTO;
import com.bits_wilp.fooddeliveryapi.dto.UserDTO;
import com.bits_wilp.fooddeliveryapi.service.UsersService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("food-delivery/api/users")
@CrossOrigin("*")
public class UserController {
//localhost:9090/api/customers/regi
    @Autowired
    private UsersService usersService;

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping(value = "/register")
    public ResponseEntity<UserDTO> registerUser(@Valid @RequestBody UserDTO userDTO) {
        UserDTO createdUser = this.usersService.createUser(userDTO);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<?> loginUser(@Valid @RequestBody LoginDTO loginDTO) {
        this.usersService.loginUser(loginDTO);
        return new ResponseEntity<>("Login Successful", HttpStatus.OK);
    }

    @PutMapping(value = "/{userID}")
    public ResponseEntity<UserDTO> updateUser(@Valid @RequestBody UserDTO userDTO, @PathVariable Long userID) {
        UserDTO updatedUser = this.usersService.updateUser(userDTO, userID);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @GetMapping(value = "/{userID}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long userID) {
        UserDTO getUser = this.usersService.getUserById(userID);
        return new ResponseEntity<>(getUser, HttpStatus.OK);
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<UserDTO>> getAllUser() {
        List<UserDTO> getAllUsers = this.usersService.getAllUsers();
        return new ResponseEntity<>(getAllUsers, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{userID}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userID) {
        this.usersService.deleteUser(userID);
        return new ResponseEntity("User Deleted", HttpStatus.OK);
//        return ResponseEntity.ok(Map.of("message","User Deleted Successfully"));
    }

}
