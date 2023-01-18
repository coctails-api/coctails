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
    private String email;
    private String password;

    public UserDTO(Integer iduser, String email, String password) {
        this.iduser = iduser;
        this.email = email;
        this.password = password;
    }

    public UserDTO() {
    }
}
