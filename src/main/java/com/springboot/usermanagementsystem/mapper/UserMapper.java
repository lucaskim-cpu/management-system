package com.springboot.usermanagementsystem.mapper;

import com.springboot.usermanagementsystem.dto.UserDto;
import com.springboot.usermanagementsystem.entity.User;

public class UserMapper {

    public static User mapToUser(UserDto userDto){
        User user = new User(
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail(),
                userDto.getPhoneNumber()
        );
        return user;
    }

    public static UserDto mapToUserDto(User user){
        UserDto userDto = new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPhoneNumber()
        );
        return userDto;
    }
}
