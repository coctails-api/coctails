package com.coctails.entity;

import com.coctails.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "confirmation_token")
public class ConfirmationTokenEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE
    )
    @Column(name = "id")
    private Integer id;
    @Column(name = "token",
            nullable = false)
    private String token;
    @Column(name = "created",
            nullable = false)
    private LocalDateTime created;
    @Column(name = "expired")
    private LocalDateTime expired;
    private LocalDateTime confirmed;
    @ManyToOne
    @JoinColumn
    private User user;

    public ConfirmationTokenEntity(String token, LocalDateTime created, LocalDateTime expired, User user) {
        this.token = token;
        this.created = created;
        this.expired = expired;
        this.user = user;
    }
}
