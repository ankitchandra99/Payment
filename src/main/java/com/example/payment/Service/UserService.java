package com.example.payment.Service;

import com.example.payment.Entity.User;
import com.example.payment.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public String addUser(User user) {
        userRepository.save(user);
        return "User added";
    }
}
