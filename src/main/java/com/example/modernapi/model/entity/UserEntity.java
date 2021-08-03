package com.example.modernapi.model.entity;

import com.example.modernapi.model.MeasurementSystemEnum;
import com.example.modernapi.model.RoleEnum;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public String uid;
//    @Column(nullable = false)
    public LocalDateTime createdAt;
    public LocalDateTime deletedAt;
//    @Column(nullable = false)
    private String loginCode;
    @Email
//    @Column(nullable = false)
    private String email;

    private String username;
//    @Column(nullable = false)
    private String password;
    @Column(columnDefinition = "boolean default false")
    private boolean isVerified;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "role")
    private RoleEnum role;

    private boolean enabled;
    private Double weight;
    private Double height;


    @Enumerated(value = EnumType.STRING)
    private MeasurementSystemEnum measurementSystemEnum;

    public UserEntity(String uid, String loginCode, @Email String email, String username, String password, RoleEnum role) {
        this.uid = uid;
        this.loginCode = loginCode;
        this.email = email;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public UserEntity(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserEntity(String uid, String loginCode, @Email String email, String username, String password, RoleEnum role, LocalDateTime createdAt) {
        this.uid = uid;
        this.loginCode = loginCode;
        this.email = email;
        this.username = username;
        this.password = password;
        this.role = role;
        this.createdAt = createdAt;
    }

    public UserEntity() {

    }
}
