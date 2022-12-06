package com.massage.service;

import com.massage.entity.Role;
import com.massage.entity.User;
import com.massage.repository.RoleRepository;
import com.massage.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    private Logger logger = LoggerFactory.getLogger(UserService.class);

    @Transactional
    public void save(User user){
        userRepository.save(user);
    }

    public void addUser(User user){
        user.setRole(new Role("USER"));
        save(user);
    }

    public void addUser(User user){
        user.setRole(roleRepository.getById( 1));
        logger.info(user.getRole().getName());
        save(user);
    }
}
