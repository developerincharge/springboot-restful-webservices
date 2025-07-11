package com.rizvi.springboot.service;

import com.rizvi.springboot.dto.UserDto;
import com.rizvi.springboot.entity.User;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto getUserById(Long userId);
    List<UserDto> getAllUsers();
    UserDto updateUser(UserDto userDto);
    void deleteUser(Long userId);
}
