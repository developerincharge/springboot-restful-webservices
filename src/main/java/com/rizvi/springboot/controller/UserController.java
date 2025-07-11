package com.rizvi.springboot.controller;

import com.rizvi.springboot.dto.UserDto;
import com.rizvi.springboot.entity.User;
import com.rizvi.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


       @PostMapping
        public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
          UserDto savedUser =  userService.createUser(userDto);
          return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
      }

       @GetMapping("/{id}")
        public ResponseEntity<UserDto> getUserById(@PathVariable ("id") Long userId){
          UserDto user =  userService.getUserById(userId);
          return new ResponseEntity<>(user, HttpStatus.OK);
      }

      @GetMapping
        public ResponseEntity<List<UserDto>> getAllUsers(){
          List<UserDto> users =  userService.getAllUsers();
          return new ResponseEntity<>(users, HttpStatus.OK);
      }

      @PutMapping("{id}")
        public ResponseEntity<UserDto> updateUser(@PathVariable ("id") Long userId, @RequestBody UserDto userDto){

          userDto.setId(userId);
          UserDto updatedUser =  userService.updateUser(userDto);
          return new ResponseEntity<>(updatedUser, HttpStatus.OK);
      }

      @DeleteMapping("{id}")
        public ResponseEntity<String> deleteUser(@PathVariable ("id") Long userId){
          userService.deleteUser(userId);
          return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
      }

}
