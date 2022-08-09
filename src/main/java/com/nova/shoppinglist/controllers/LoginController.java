package com.nova.shoppinglist.controllers;

import com.nova.shoppinglist.dto.UserDto;
import com.nova.shoppinglist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @GetMapping("/register")
    public String getRegister(Model model) {
        model.addAttribute("user", new UserDto());
        return "register";
    }

    @PostMapping("/register")
    public String registerNewUser(@Valid UserDto userDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "register";
        }
        if(!userDto.getUserPassword().equals(userDto.getRepeatUserPassword())){
            bindingResult.rejectValue("userPassword", "", "Пароли не совпадают");
            return "register";
        }
        userService.userSave(userDto);
        return "redirect:/login";
    }
}
