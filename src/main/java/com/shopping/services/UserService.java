package com.shopping.services;

import com.shopping.entities.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User getUserByUserName(String username);

    User saveUser(User user);
}
