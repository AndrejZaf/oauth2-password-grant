package com.example.modernapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;
@Getter
@Setter
public class UserDto implements Serializable {
    private String uid;
    private String LoginCode;
    @NotNull
    @NotBlank
    @Email
    private String email;
    @NotNull
    @NotBlank
    private String username;
    @NotNull
    @NotBlank
    private String password;
    @NotNull
    @NotBlank
    private String matchingPassword;
    private RoleEnum role;
    private Double weight;
    private Double height;
    private LocalDateTime createdAt;
    private MeasurementSystemEnum measurementSystemEnum;

    public UserDto(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public UserDto() {
    }
}
