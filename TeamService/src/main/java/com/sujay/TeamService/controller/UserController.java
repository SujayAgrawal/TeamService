package com.sujay.TeamService.controller;

import com.sujay.TeamService.model.UserInfo;
import com.sujay.TeamService.repo.UserInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserInfoRepo repo;

    @Autowired
    private PasswordEncoder encoder;

    @PostMapping("/new")
    public String add(@RequestBody UserInfo user) {
        user.setPassword(encoder.encode(user.getPassword()));
        repo.save(user);
        return "User Created";
    }

    @GetMapping("/{username}")
    public UserInfo getUser(@PathVariable String username) {
        return repo.getUserByName(username);
    }

    @GetMapping("/all")
    public List<UserInfo> getAllUsers() {
        return repo.getAll();
    }
}
