package com.rizvi.springboot.service.impl;

import com.rizvi.springboot.dto.UserDto;
import com.rizvi.springboot.entity.User;
import com.rizvi.springboot.mapper.UserMapper;
import com.rizvi.springboot.repository.UserRepository;
import com.rizvi.springboot.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

      private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {

        // convertUserDto into User Jpa Entity
         User user = UserMapper.mapToUser(userDto);
         User savedUser = userRepository.save(user);
         // convert User Jpa Entity into UserDto
         UserDto savedUserDto = UserMapper.mapToUserDto(savedUser);
           return savedUserDto;
    }

    @Override
    public UserDto getUserById(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
         User user =optionalUser.get();
         return UserMapper.mapToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(UserMapper::mapToUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        User existingUser = userRepository.findById(userDto.getId()).get();

         existingUser.setFirstName(userDto.getFirstName());
         existingUser.setLastName(userDto.getLastName());
         existingUser.setEmail(userDto.getEmail());
         User updatedUser = userRepository.save(existingUser);
        return UserMapper.mapToUserDto(updatedUser);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);


    }
}
