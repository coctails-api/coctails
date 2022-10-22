package com.massage.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "category")
@Getter
public class Category {
    @Id
    @Column(name = "idcategory")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idcategory;

    @Column(name ="name")
    private String name;

    public Category(String name) {
        this.name = name;
    }

    public Category() {

    }
}
