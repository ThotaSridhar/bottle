package com.sridhar.bottle.service.impl;

import com.sridhar.bottle.domain.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    static Map<String, User> userMap = new HashMap<>();
    static {
        User user = new User();
        user.setId("1");
        user.setUsername("admin");
        user.setPassword("admin");
        user.setAuthority("ADMIN");
        userMap.put(user.getUsername(), user);

        User user2 = new User();
        user2.setId("2");
        user2.setUsername("user");
        user2.setPassword("user");
        user2.setAuthority("USER");
        userMap.put(user2.getUsername(), user2);
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(userMap.containsKey(username)){
            return userMap.get(username);
        }
        else throw new UsernameNotFoundException("User not found");
    }
}
