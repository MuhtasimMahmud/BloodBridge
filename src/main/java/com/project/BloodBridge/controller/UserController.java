package com.project.BloodBridge.controller;

import com.project.BloodBridge.model.Post;
import com.project.BloodBridge.model.User;
import com.project.BloodBridge.repository.UserRepository;
import com.project.BloodBridge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/userRegistration")
    private User registerUserAccount(@RequestBody User user){
        return userService.createUserAccount(user);
    }


    @PutMapping("/updateUserAccount")
    private User updateUserAccount(@RequestBody User user){
        return userService.updateAccount(user);
    }

    @PostMapping("/bloodPost/{id}")
    private List<Post> bloodPost(@RequestBody Post post, @PathVariable String id){
        return userService.createBloodPost(post, id);
    }


}
