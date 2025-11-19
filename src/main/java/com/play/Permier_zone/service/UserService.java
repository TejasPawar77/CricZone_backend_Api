package com.play.Permier_zone.service;

import com.play.Permier_zone.model.User;
import com.play.Permier_zone.reppositories.UserRepository;
import com.play.Permier_zone.service.EmailService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository, EmailService emailService) {
        this.userRepository = userRepository;
    }
    public List<User> allUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }
}
