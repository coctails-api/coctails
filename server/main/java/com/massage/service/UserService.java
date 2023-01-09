package com.massage.service;

import com.massage.entity.Role;
import com.massage.entity.User;
import com.massage.regex.Validator;
import com.massage.repository.RoleRepository;
import com.massage.repository.UserRepository;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@Log4j2
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Transactional
    public void save(User user){
        userRepository.save(user);
    }

    public void addUser(User user){
        user.setRole(roleRepository.findById(1).get());
        save(user);
    }

    public ResponseEntity<?> validation(User user){
        ResponseEntity<?> validationResult = Validator.validator(user);
        if(validationResult != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return null;
    }

//    public void addUser(User user){
//        user.setRole(roleRepository.getById( 1));
//        logger.info(user.getRole().getName());
//        save(user);
//    }
}
