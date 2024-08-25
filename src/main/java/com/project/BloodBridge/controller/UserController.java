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

    @GetMapping("/myProfile/{id}")
    private User userProfile(@PathVariable String id){
        return userService.showUserProfile(id);
    }

    @PutMapping("/updateUserAccount")
    private User updateUserAccount(@RequestBody User user){
        return userService.updateAccount(user);
    }

    @GetMapping("/allPost")
    private List<Post> showAllPosts(){
        return userService.showAllPost();
    }

    @PostMapping("/bloodPost/{postGivingUserId}")
    private List<Post> bloodPosts(@RequestBody Post post, @PathVariable String postGivingUserId){
        return userService.createBloodPost(post, postGivingUserId);
    }

    @GetMapping("/bloodPost/{bloodPostId}")
    private Post bloodPost(@PathVariable int bloodPostId){
        return userService.showSpecificPost(bloodPostId);
    }

    @PutMapping("/editPost/{userID}/{postId}")
    private Post editPost(@PathVariable String userID, @PathVariable int postId, @RequestBody Post post){
        return userService.editPost(userID, postId, post);
    }

    @GetMapping("/myPosts/{userId}")
    private List<Post> myPosts(@PathVariable String userId){
        return userService.showMyAllPosts(userId);
    }




}
