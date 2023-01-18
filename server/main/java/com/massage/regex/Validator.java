package com.massage.regex;

import com.massage.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Validator {
    public static ResponseEntity<?> validator(User user){
        if(EmailValidator.emailValidator(user.getEmail()) ||
        PasswordValidator.passwordValidator(user.getPassword())){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return null;
    }
}
