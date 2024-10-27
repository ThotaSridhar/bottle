package com.sridhar.bottle.service.impl;

import com.sridhar.bottle.domain.User;
import com.sridhar.bottle.reponsitory.UserRepository;
import com.sridhar.bottle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@Service
public class UserDetailsServiceImpl implements UserService {


    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user=  userRepository.findByUsername(username);
        return user.orElseThrow(()-> new UsernameNotFoundException("user not found"));
    }

    @Override
    public void addUser(User user) {
        Optional<User> opUser= userRepository.findByUsername(user.getUsername());
        if(opUser.isEmpty()){
            user.setAuthority("USER");
            user.setPassword(encoder.encode(user.getPassword()));
            userRepository.save(user);
        }
        else throw new RuntimeException("user already exists");
    }
}
