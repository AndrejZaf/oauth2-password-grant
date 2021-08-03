package com.example.modernapi.model.mapper;

import com.example.modernapi.model.UserDto;
import com.example.modernapi.model.entity.UserEntity;

public class UserMapper {
    public static UserDto toUser(UserEntity userEntity){
        return new UserDto(
                userEntity.getEmail(),
                userEntity.getUsername(),
                userEntity.getPassword());
    }

    public static UserEntity toUserEntity(UserDto userDto){
        return new UserEntity(
                userDto.getUid(),
                userDto.getLoginCode(),
                userDto.getEmail(),
                userDto.getUsername(),
                userDto.getPassword(),
                userDto.getRole(),
                userDto.getCreatedAt()
        );
    }
}
