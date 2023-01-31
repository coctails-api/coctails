package com.coctails.controller;

import com.coctails.dto.UserDTO;
import com.coctails.service.ConfirmationTokenService;
import com.coctails.entity.User;
import com.coctails.regex.StaticVariables;
import com.coctails.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "${api.client}")
@RequestMapping("/user")
@RestController
@Log4j2
public class RegisterController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/register")
    public ResponseEntity<?> registerUser(@RequestBody User user, ModelMapper modelMapper) {
        log.info("Register user");
        if(userService.userExists(user.getEmail().toLowerCase()))
            return new ResponseEntity<>(StaticVariables.emailExists, HttpStatus.CONFLICT);
        User newUser = new User();
        modelMapper.map(user, newUser);
        userService.validation(user);
        userService.addUser(newUser);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/generateNewEmailPassword")
    public ResponseEntity<?> generateNewEmailPassword(@RequestBody User userE) {
        User user = userService.findUserByEmail(userE.getEmail());
        log.info("generateNewEmailPassword: " + user.getEmail() + user.getPassword());
        userService.generateNewEmailPassword(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/generateNewPassword")
    public ResponseEntity<?> generateNewPassword(@RequestParam("token") String token){
        log.info("generate new password: " + token);
        return userService.confirmToken(token);
    }

    @PutMapping(value = "/newPassword")
    public ResponseEntity<?> newPassword(@RequestParam("password") String password, @RequestParam("token") String token){
        log.info(password + " " + token);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
