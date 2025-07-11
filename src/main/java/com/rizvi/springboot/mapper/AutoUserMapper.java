package com.rizvi.springboot.mapper;

import com.rizvi.springboot.dto.UserDto;
import com.rizvi.springboot.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoUserMapper {

     AutoUserMapper MAPPER = Mappers.getMapper(AutoUserMapper.class);

     UserDto mapToUserDto(User user);

     User mapToUser(UserDto userDto);
}
