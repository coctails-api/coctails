package com.coctails.controller;

import com.coctails.controller.token.ConfirmationTokenService;
import com.coctails.entity.User;
import com.coctails.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "${api.client}")
@RestController
@RequestMapping("/user")
@Log4j2
public class RegisterController {
    @Autowired
    private UserService userService;
    @Autowired
    private ConfirmationTokenService confirmationTokenService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user, ModelMapper modelMapper) {
        log.info("Register user");
        if(userService.userExists(user.getEmail().toLowerCase()))
            return new ResponseEntity<>("User exists", HttpStatus.CONFLICT);
        User newUser = new User();
        modelMapper.map(user, newUser);
        userService.validation(user);
        userService.addUser(newUser);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
