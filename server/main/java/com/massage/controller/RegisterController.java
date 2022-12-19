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
        log.info(user.getLogin());
        log.info(user.getEmail());
        log.info(user.getPassword());
        log.info(user.getPhone());
//        if (user.getEmail() == null) {
//            log.info("null");
//            return new ResponseEntity("xca", HttpStatus.BAD_REQUEST);
//        }
        User userx = new User();
        modelMapper.map(user, userx);
        userService.addUser(userx);
        return new ResponseEntity<>( HttpStatus.OK);

        //@PostMapping("/register")
        //public void registerUser(@RequestBody UserDTO userDTO, ModelMapper modelMapper){
        //    logger.info("xxx");
        //    User user = new User();
        //    modelMapper.map(userDTO, user);
        //    userService.addUser(user);
        //    //return new ResponseEntity<>("Success", HttpStatus.CREATED);
//
        //  }


//    @GetMapping("/register")
//    public void registerUser() {
//        logger.info("register");
//    }
    }
}
