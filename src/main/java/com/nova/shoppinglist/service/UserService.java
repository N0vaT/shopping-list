package com.nova.shoppinglist.service;

import com.nova.shoppinglist.dao.UserRepository;
import com.nova.shoppinglist.domain.User;
import com.nova.shoppinglist.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public boolean userSave(UserDto userDto){
        if(repository.findByUserName(userDto.getUserName()).isPresent()){
            return false;
        }
        User user = new User();

        user.setUserName(userDto.getUserName());
        user.setUserPassword(passwordEncoder.encode(userDto.getUserPassword()));
        repository.save(user);
        return true;
    }

}
