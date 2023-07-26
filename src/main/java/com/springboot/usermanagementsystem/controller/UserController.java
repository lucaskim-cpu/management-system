package com.springboot.usermanagementsystem.controller;

import com.springboot.usermanagementsystem.dto.UserDto;
import com.springboot.usermanagementsystem.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @GetMapping("/users")
    public String listAllUsers(Model model){
        List<UserDto> userDtos = userService.getAllUsers();
        model.addAttribute("users", userDtos);
        return "users";
    }
    @GetMapping("/users/create")
    public String createUser(Model model){
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "create_user";
    }

    @PostMapping("/users")
    public String savedUser(@Valid @ModelAttribute("user") UserDto userDto,
                            BindingResult result,
                            Model model){
        if(result.hasErrors()){
            model.addAttribute("user", userDto);
            return "create_user";
        }

        userService.createUser(userDto);
        return "redirect:/users";
    }

    @GetMapping("users/{userId}/edit")
    public String editUser(@PathVariable("userId") Long userId,
                           Model model){
        UserDto userDto = userService.getUserById(userId);
        model.addAttribute("user", userDto);
        return "edit_user";
    }

    @PostMapping("/users/{userId}")
    public String updateUser(@PathVariable("userId") Long userId,
                             @Valid @ModelAttribute("user") UserDto userDto,
                             BindingResult result,
                             Model model){
        if(result.hasErrors()){
            model.addAttribute("user", userDto);
            return "edit_user";
        }
        userDto.setId(userId);
        userService.updateUser(userDto);
        return "redirect:/users";
    }



}
