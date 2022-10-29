package com.massage.entity;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;

@Entity
@Getter
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iduser")
    private Integer iduser;

    @Column(name = "login")
    private String login;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "phone")
    private String phone;

    @ManyToOne
    private Role role;


    public User(String login, String email, String password, String phone, Role role) {
        this.login = login;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.role = role;
    }

    public User() {
    }
}
