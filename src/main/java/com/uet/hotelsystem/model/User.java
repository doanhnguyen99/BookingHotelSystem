package com.uet.hotelsystem.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String username;
    private String email;
    private String password;
    private String role;
    private boolean enabled;

    @Enumerated(EnumType.STRING)
    private Provider provider;

    @Column(name = "reset_password_token")
    private String resetPasswordToken;
}