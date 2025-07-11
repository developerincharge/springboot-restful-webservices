package com.rizvi.springboot.controller;

import com.rizvi.springboot.dto.UserDto;
import com.rizvi.springboot.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Tag(name = "CRUD REST APIs for User Resource",
        description = "Create User, Get User, Get All Users," +
                " Update User, Delete User, CRUD REST APIs operation for User Resource")
@RestController
@RequestMapping("api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

   @Operation(
           summary = "Create User Rest API",
           description = "Create User REST API"
   )
    @ApiResponse(
            responseCode = "201",
            description = "Http Status 201 : User created successfully"
   )
    @PostMapping
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
        UserDto savedUser = userService.createUser(userDto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }


    @Operation(
            summary = "Get User By ID Rest API",
            description = "Get User By Id REST API to get single user by id from Database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 200 : Retrieve Single User"
    )
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userId) {
        UserDto user = userService.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @Operation(
            summary = "Get AllUsers Rest API",
            description = "Get the List of all the Users from Database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 200 : Retrieve All Users List"
    )
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @Operation(
            summary = "Update User Rest API",
            description = "Update User Api to update a particular users information in the Database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 200 : Update Single User"
    )
    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateUser(@Valid @PathVariable("id") Long userId, @RequestBody UserDto userDto) {

        userDto.setId(userId);
        UserDto updatedUser = userService.updateUser(userDto);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @Operation(
            summary = "Delete User Rest API",
            description = "Delete User By Id in the Database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 200 : Delete a Single User"
    )
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
    }

}