package com.springboot.usermanagementsystem.service.impl;
import com.springboot.usermanagementsystem.dto.UserDto;
import com.springboot.usermanagementsystem.entity.User;
import com.springboot.usermanagementsystem.mapper.UserMapper;
import com.springboot.usermanagementsystem.repository.UserRepository;
import com.springboot.usermanagementsystem.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    // list users
    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = users.stream().map((user) -> UserMapper.mapToUserDto(user)).collect(Collectors.toList());
        return userDtos;
    }

    // create users
    @Override
    public void createUser(UserDto userDto) {
        User user = UserMapper.mapToUser(userDto);
        userRepository.save(user);
    }

    @Override
    public UserDto getUserById(Long userId) {
        User user = userRepository.findById(userId).get();
        return UserMapper.mapToUserDto(user);
    }

    @Override
    public void updateUser(UserDto userDto) {
        userRepository.save(UserMapper.mapToUser(userDto));
    }


}
