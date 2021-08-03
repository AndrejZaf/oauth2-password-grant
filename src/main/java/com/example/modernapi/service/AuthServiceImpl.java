package com.example.modernapi.service;

import com.example.modernapi.exceptions.PasswordNotMatchingException;
import com.example.modernapi.exceptions.UsernameAlreadyExistsException;
import com.example.modernapi.model.RoleEnum;
import com.example.modernapi.model.UserDto;
import com.example.modernapi.model.entity.UserEntity;
import com.example.modernapi.model.mapper.UserMapper;
import com.example.modernapi.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;
@Service
public class AuthServiceImpl implements AuthService{
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void registerUser(UserDto userDto) {
        if(!userDto.getPassword().equals(userDto.getMatchingPassword())){
            throw new PasswordNotMatchingException("Password doesn't match");
        }
        if(this.userRepository.findByUsernameOrEmail(userDto.getUsername(), userDto.getEmail()).isPresent()){
            throw new UsernameAlreadyExistsException("Username/Email already exist");
        }
        userDto.setLoginCode(UUID.randomUUID().toString());
        userDto.setUid(UUID.randomUUID().toString());
        userDto.setRole(RoleEnum.ROLE_BRONZE);
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userDto.setCreatedAt(LocalDateTime.now());
        UserEntity userEntity = UserMapper.toUserEntity(userDto);
        userRepository.save(userEntity);
    }
}
