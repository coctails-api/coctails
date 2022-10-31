package com.massage.controller;

import com.massage.dto.UserDTO;
import com.massage.entity.User;
import com.massage.service.UserService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegisterController {
    @Autowired
    private UserService userService;
    private Logger logger = LoggerFactory.getLogger(RegisterController.class);

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserDTO userDTO, ModelMapper modelMapper){
        User user = new User();
        modelMapper.map(userDTO, user);
        userService.addUser(user);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    @GetMapping("/register")
    public void registerUser() {
        logger.info("register");
    }
}
