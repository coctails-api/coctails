package com.massage.controller;

import com.massage.entity.User;
import com.massage.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Controller
@RequestMapping("/user")
@Log4j2
public class RegisterController {
    @Autowired
    private UserService userService;

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
