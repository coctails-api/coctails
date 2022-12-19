package com.massage.service;

import com.massage.entity.Role;
import com.massage.entity.User;
import com.massage.repository.RoleRepository;
import com.massage.repository.UserRepository;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

//    public void addUser(User user){
//        user.setRole(roleRepository.getById( 1));
//        logger.info(user.getRole().getName());
//        save(user);
//    }
}
