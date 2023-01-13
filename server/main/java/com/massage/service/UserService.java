package com.massage.service;

import com.massage.entity.Role;
import com.massage.entity.User;
import com.massage.regex.Validator;
import com.massage.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@Log4j2
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Transactional
    public void save(User user) {
        userRepository.save(user);
    }

    public void addUser(User user) {
        userFormat(user);
        save(user);
    }

    private void userFormat(User user) {
        user.setEmail(user.getEmail().toLowerCase());
        user.setRole(Role.USER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
    }

    public boolean userExists(String email) {
        email = userRepository.findByEmail(email).getEmail();
        return email != null;
    }

    public ResponseEntity<?> validation(User user) {
        ResponseEntity<?> validationResult = Validator.validator(user);
        if (validationResult != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return null;
    }
}
