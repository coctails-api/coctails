package com.massage.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "role")
public class Role {
    @Id
    @Column(name = "idroles")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idroles;

    @Column(name = "name")
    private String name;

    public Role(String name) {
        this.name = name;
    }

    public Role() {
    }
}