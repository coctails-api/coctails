package com.coctails.controller.token;

import com.coctails.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "${api.client}")
@RestController
@Slf4j
@RequestMapping("/user")
public class EmailController {
    @Autowired
    private UserService userService;

    @GetMapping(path = "/confirm")
    public String confirm(@RequestParam("token") String token) {
        log.info("confirm token: " + token);
        return userService.confirmToken(token);
    }

    @GetMapping(path = "/confirmx")
    public ResponseEntity<String> confirmx() {
        log.info("confirm");
        return ResponseEntity.ok("dziala");
    }
}
