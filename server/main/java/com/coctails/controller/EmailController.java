package com.coctails.controller;

import com.coctails.service.EmailService;
import com.coctails.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "${api.client}")
@RequestMapping(value = "/user")
@RestController
@Log4j2
public class EmailController {
    @Autowired
    private UserService userService;

    @GetMapping(path = "/confirm")
    public ResponseEntity<?> confirm(@RequestParam("token") String token) {
        log.info("confirm token: " + token);
        return userService.confirmToken(token);
    }

    @PutMapping(path = "/generateNewToken")
    public ResponseEntity<?> generateNewToken(@RequestBody Object object) {
        log.info("/confirm/token" + object.toString());
//        userService.generateNewToken(token);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
