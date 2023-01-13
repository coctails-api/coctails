package com.massage.service;

import com.massage.controller.token.ConfirmationToken;
import com.massage.controller.token.ConfirmationTokenRepository;
import com.massage.controller.token.ConfirmationTokenService;
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
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@Log4j2
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private ConfirmationTokenService tokenService;

    @Transactional
    public void save(User user) {
        userRepository.save(user);
    }

    public void addUser(User user) {
        userFormat(user);
        ConfirmationToken confirmationToken= new ConfirmationToken(
                UUID.randomUUID().toString(),
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                user
        );
        tokenService.save(confirmationToken);
        save(user);
    }

    private void userFormat(User user) {
        user.setEmail(user.getEmail().toLowerCase());
        user.setRole(Role.USER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
    }

    public boolean userExists(String email) {
        User tempUser = userRepository.findByEmail(email);
        return tempUser != null;
    }

    public ResponseEntity<?> validation(User user) {
        ResponseEntity<?> validationResult = Validator.validator(user);
        if (validationResult != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return null;
    }
}
