package com.massage.controller.token;

import com.massage.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;
import org.springframework.scheduling.quartz.LocalDataSourceJobStore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "confirmation_token")
public class ConfirmationToken {
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

    public ConfirmationToken(String token, LocalDateTime created, LocalDateTime expired, User user) {
        this.token = token;
        this.created = created;
        this.expired = expired;
        this.user = user;
    }
}
