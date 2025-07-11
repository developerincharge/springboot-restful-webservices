package com.rizvi.springboot.mapper;

import com.rizvi.springboot.dto.UserDto;
import com.rizvi.springboot.entity.User;

public class UserMapper {

      // convert User Jpa Entity into UserDto

    public static UserDto mapToUserDto(User user) {
        UserDto userDto = new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail());

        return userDto;
    }

       // convert UserDto into User Jpa Entity
    public static User mapToUser(UserDto userDto) {
        User user = new User(
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail());
        return user;
    }
}
