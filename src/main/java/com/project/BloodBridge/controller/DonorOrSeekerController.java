package com.project.BloodBridge.controller;

import com.project.BloodBridge.model.DonorOrSeeker;
import com.project.BloodBridge.model.Post;
import com.project.BloodBridge.service.DonorOrSeekerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DonorOrSeekerController {

    @Autowired
    private DonorOrSeekerService donorOrSeekerService;

    @PostMapping("/donorOrSeekerRegistration")
    private DonorOrSeeker registerDonorOrSeekerAccount(@RequestBody DonorOrSeeker donorOrSeeker){
        return donorOrSeekerService.createUserAccount(donorOrSeeker);
    }

    @GetMapping("/myProfile/{id}")
    private DonorOrSeeker donorOrSeekerProfile(@PathVariable String id){
        return donorOrSeekerService.showUserProfile(id);
    }

    @PutMapping("/updateDonorOrSeekerAccount")
    private DonorOrSeeker updateDonorOrSeekerAccount(@RequestBody DonorOrSeeker donorOrSeeker){
        return donorOrSeekerService.updateAccount(donorOrSeeker);
    }

    @GetMapping("/allPost")
    private List<Post> showAllPosts(){
        return donorOrSeekerService.showAllPost();
    }

    @PostMapping("/bloodPost/{postGivingUserId}")
    private List<Post> bloodPosts(@RequestBody Post post, @PathVariable String postGivingUserId){
        return donorOrSeekerService.createBloodPost(post, postGivingUserId);
    }

    @GetMapping("/bloodPost/{bloodPostId}")
    private Post bloodPost(@PathVariable int bloodPostId){
        return donorOrSeekerService.showSpecificPost(bloodPostId);
    }

    @PutMapping("/editPost/{donorOrSeekerID}/{postId}")
    private Post editPost(@PathVariable String donorOrSeekerID, @PathVariable int postId, @RequestBody Post post){
        return donorOrSeekerService.editPost(donorOrSeekerID, postId, post);
    }

    @GetMapping("/myPosts/{userId}")
    private List<Post> myPosts(@PathVariable String userId){
        return donorOrSeekerService.showMyAllPosts(userId);
    }
}
