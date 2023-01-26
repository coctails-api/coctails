package com.coctails.controller;

import com.coctails.config.JwtTokenUtil;
import com.coctails.entity.JwtResponse;
import com.coctails.entity.User;
import com.coctails.service.JwtUserDetailsService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "${api.client}")
@RestController
@RequestMapping("/user")
@Log4j2
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
        user.setEmail(user.getEmail().toLowerCase());
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
