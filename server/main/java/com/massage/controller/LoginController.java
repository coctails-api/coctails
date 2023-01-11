package com.massage.controller;

import com.massage.config.JwtTokenUtil;
import com.massage.dto.UserDTO;
import com.massage.entity.JwtResponse;
import com.massage.entity.User;
import com.massage.service.JwtUserDetailsService;
import com.massage.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/user")
@Slf4j
public class LoginController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public ResponseEntity<?> signIn(@RequestBody User user) throws Exception {
        authenticate(user.getEmail(), user.getPassword());

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(user.getEmail());

        final String token = jwtTokenUtil.generateToken(userDetails);
        log.info(token);

        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
