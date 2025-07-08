package com.shetty.ecommerce.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shetty.ecommerce.Entities.User;
import com.shetty.ecommerce.dao.UserRepository;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;
    
    public User findUser(String email) {
        logger.info("🔍 Looking for user by email: {}", email);
        User user = userRepository.findByEmail(email);
        if (user != null) {
            logger.info("✅ User found: {}", email);
        } else {
            logger.warn("❗ No user found for email: {}", email);
        }
        return user;
    }
}
