package com.shopping.controllers;

import com.shopping.entities.User;
import com.shopping.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("account")
public class AccountController {

    @Autowired
    private UserService userService;

    @CrossOrigin
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@RequestBody User newUser) {
        if (userService.getUserByUserName(newUser.getUsername()) != null) {
            return new ResponseEntity("The username " + newUser.getUsername() + " already exist", HttpStatus.CONFLICT);
        }
        newUser.setRole("USER");
        return new ResponseEntity<User>(userService.saveUser(newUser), HttpStatus.CREATED);
    }

    @CrossOrigin
    @RequestMapping("/login")
    public Principal user(Principal principal) {
        return principal;
    }
}
