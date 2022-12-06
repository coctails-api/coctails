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
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin("*")
@RequestMapping("/user")
public class LoginController {
    @Autowired
    private UserService userService;

    private Logger logger = LoggerFactory.getLogger(RegisterController.class);

    @PostMapping("/login")
    public ResponseEntity<String> registerUser(@RequestBody UserDTO userDTO, ModelMapper modelMapper){
        logger.info("Register user");
        User user = new User();
        modelMapper.map(userDTO, user);
        userService.addUser(user);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @GetMapping("/x")
    public String lol(){
        return "dziala!!";
    }
}
