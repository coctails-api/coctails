package com.coctails.controller;

import com.coctails.service.EmailService;
import com.coctails.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "${api.client}")
@RestController
@Log4j2
@RequestMapping("/user")
public class EmailController {
    @Autowired
    private UserService userService;

    @GetMapping(path = "/confirm")
    public String confirm(@RequestParam("token") String token) {
        log.info("confirm token: " + token);
        return userService.confirmToken(token);
    }

    @PutMapping(path = "/generateNewToken/{token}")
    public ResponseEntity<?> generateNewToken(@PathVariable("token") String token) {
        log.info("/confirm/token");
        userService.generateNewToken(token);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
