package com.massage.controller;

import com.massage.entity.User;
import com.massage.service.UserService;
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
@CrossOrigin
@RequestMapping("/user")
public class RegisterController {
    @Autowired
    private UserService userService;
    private Logger logger = LoggerFactory.getLogger(RegisterController.class);


    @PostMapping("user/register")
    public ResponseEntity registerUser(@RequestBody User user, ModelMapper modelMapper){
        logger.info("Register user");
        logger.info(user.getLogin());
        logger.info(user.getEmail());
        logger.info(user.getPassword());
        logger.info(user.getPhone());
        if(user.getEmail() == null){
            logger.info("null");
            return new ResponseEntity("xca", HttpStatus.BAD_REQUEST);
        }
        User userx = new User();
        modelMapper.map(user, userx);
        userService.addUser(userx);
        return ResponseEntity.ok("sda");

    //@PostMapping("/register")
    //public void registerUser(@RequestBody UserDTO userDTO, ModelMapper modelMapper){
    //    logger.info("xxx");
    //    User user = new User();
    //    modelMapper.map(userDTO, user);
    //    userService.addUser(user);
    //    //return new ResponseEntity<>("Success", HttpStatus.CREATED);
//
  //  }
    


    @GetMapping("/register")
    public void registerUser() {
        logger.info("register");
    }
}
