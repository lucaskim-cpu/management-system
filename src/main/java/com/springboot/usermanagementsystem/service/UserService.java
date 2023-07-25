package com.springboot.usermanagementsystem.service;

import com.springboot.usermanagementsystem.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getAllUsers();

    void createUser(UserDto userDto);
}
