package com.investmentiq.users.controllers;

import com.investmentiq.users.entities.User;
import com.investmentiq.users.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.investmentiq.base.globalConstants.Constants.baseUrl;

@RestController
@RequestMapping(baseUrl + "/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody User user)
    {
        userService.createUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody User user)
    {
        userService.updateUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/family-members")
    public ResponseEntity<?> getFamilyMembers()
    {
        return new ResponseEntity<>(userService.findAllFamilyMembers(),HttpStatus.OK);
    }
}
