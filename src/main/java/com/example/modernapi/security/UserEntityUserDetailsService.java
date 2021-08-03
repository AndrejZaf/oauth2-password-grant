package com.example.modernapi.security;

import com.example.modernapi.model.entity.UserEntity;
import com.example.modernapi.repository.UserRepository;
import com.example.modernapi.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserEntityUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity u = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Username or email does not exist"));
        return new CustomUserDetails(u);
    }

    public boolean existsByUsernameOrEmail(String username){
        return userRepository.existsByUsernameOrEmail(username, username);
    }
}
