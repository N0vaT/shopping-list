package com.nova.shoppinglist.security;

import com.nova.shoppinglist.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserAuthService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByUserName(username)
                .map(user-> new User(
                        user.getUserName(),
                        user.getUserPassword(),
                        Collections.singletonList(new SimpleGrantedAuthority("USER"))
                )).orElseThrow(() -> new UsernameNotFoundException("Пользователь не найден"));
    }
}
