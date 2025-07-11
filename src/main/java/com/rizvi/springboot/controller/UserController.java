package com.rizvi.springboot.controller;

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
        public ResponseEntity<User> createUser(@RequestBody User user){
          User savedUser =  userService.createUser(user);
          return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
      }

       @GetMapping("/{id}")
        public ResponseEntity<User> getUserById(@PathVariable ("id") Long userId){
          User user =  userService.getUserById(userId);
          return new ResponseEntity<>(user, HttpStatus.OK);
      }

      @GetMapping
        public ResponseEntity<List<User>> getAllUsers(){
          List<User> users =  userService.getAllUsers();
          return new ResponseEntity<>(users, HttpStatus.OK);
      }

      @PutMapping("{id}")
        public ResponseEntity<User> updateUser(@PathVariable ("id") Long userId, @RequestBody User user){

          user.setId(userId);
          User updatedUser =  userService.updateUser(user);
          return new ResponseEntity<>(updatedUser, HttpStatus.OK);
      }

      @DeleteMapping("{id}")
        public ResponseEntity<String> deleteUser(@PathVariable ("id") Long userId){
          userService.deleteUser(userId);
          return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
      }

}
