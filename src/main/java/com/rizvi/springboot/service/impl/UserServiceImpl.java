package com.rizvi.springboot.service.impl;

import com.rizvi.springboot.dto.UserDto;
import com.rizvi.springboot.entity.User;
import com.rizvi.springboot.exception.EmailAlreadyExistsException;
import com.rizvi.springboot.exception.ResourceNotFoundException;
import com.rizvi.springboot.mapper.AutoUserMapper;
import com.rizvi.springboot.mapper.UserMapper;
import com.rizvi.springboot.repository.UserRepository;
import com.rizvi.springboot.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

      private UserRepository userRepository;
      //private ModelMapper modelMapper;


    @Override
    public UserDto createUser(UserDto userDto) {

        // convertUserDto into User Jpa Entity
        // User user = UserMapper.mapToUser(userDto);
        // User user = modelMapper.map(userDto, User.class);

         Optional<User> optionalUser = userRepository.findByEmail(userDto.getEmail());
         if (optionalUser.isPresent()) {
             throw new EmailAlreadyExistsException("User with email " + userDto.getEmail() + "  already exists.");
         }

         User user = AutoUserMapper.MAPPER.mapToUser(userDto);
         User savedUser = userRepository.save(user);
         // convert User Jpa Entity into UserDto
         //UserDto savedUserDto = UserMapper.mapToUserDto(savedUser);
        // UserDto savedUserDto = modelMapper.map(savedUser, UserDto.class);
         UserDto savedUserDto = AutoUserMapper.MAPPER.mapToUserDto(savedUser);
           return savedUserDto;
    }

    @Override
    public UserDto getUserById(Long userId) {

         User user  = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

         //return UserMapper.mapToUserDto(user);
        // return modelMapper.map(user, UserDto.class);
         return AutoUserMapper.MAPPER.mapToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        //return users.stream().map(UserMapper::mapToUserDto).collect(Collectors.toList());
        return users.stream()
                //.map((user) -> modelMapper
                .map(AutoUserMapper.MAPPER::mapToUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        //User existingUser = userRepository.findById(userDto.getId()).get();
        User existingUser  = userRepository.findById(userDto.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userDto.getId()));

         existingUser.setFirstName(userDto.getFirstName());
         existingUser.setLastName(userDto.getLastName());
         existingUser.setEmail(userDto.getEmail());
         User updatedUser = userRepository.save(existingUser);
        //return UserMapper.mapToUserDto(updatedUser);
        //return modelMapper.map(updatedUser, UserDto.class);
        return AutoUserMapper.MAPPER.mapToUserDto(updatedUser);
    }

    @Override
    public void deleteUser(Long userId) {
        User existingUser  = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        userRepository.deleteById(userId);

    }
}
