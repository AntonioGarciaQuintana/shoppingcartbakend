package com.shopping.services.Impl;

import com.shopping.entities.User;
import com.shopping.repositories.UserRepository;
import com.shopping.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User getUserByUserName(String username) {
        return this.userRepository.getByUserByUserName(username);
    }

    @Override
    public User saveUser(User user) {
        return this.userRepository.save(user);
    }
}
