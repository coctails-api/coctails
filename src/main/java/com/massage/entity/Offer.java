package com.massage.entity;

import javax.persistence.*;


@Entity
@Table(name = "offer")
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idoffer")
    private Integer idoffer;

    @Column(name = "name")
    private String name;

    @Column(name = "content")
    private String content;

    @Column(name = "price")
    private float price;

    @Column(name = "photo")
    private String photo;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Label label;

    public Offer(String name, String content, float price, String photo, Category category, Label label) {
        this.name = name;
        this.content = content;
        this.price = price;
        this.photo = photo;
        this.category = category;
        this.label = label;
    }

    public Offer() {
    }
}
