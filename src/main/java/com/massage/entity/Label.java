package com.massage.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "label")
@Getter
public class Label {
    @Id
    @Column(name = "idlabel")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idlabel;

    @Column(name = "name")
    private String name;

    @Column(name = "content")
    private String content;

    public Label(String name, String content) {
        this.name = name;
        this.content = content;
    }

    public Label() {
    }
}
