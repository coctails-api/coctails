package com.massage.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
@ToString
public class UserDTO {
    private Integer iduser;
    private String login;
    private String email;
    private String password;
    private String phone;

    public UserDTO(Integer iduser, String login, String email, String password, String phone) {
        this.iduser = iduser;
        this.login = login;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }

    public UserDTO() {
    }
}
