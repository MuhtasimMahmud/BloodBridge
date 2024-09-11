package com.project.BloodBridge.service;

import com.project.BloodBridge.model.DonorOrSeeker;
import com.project.BloodBridge.model.Post;
import com.project.BloodBridge.repository.PostRepository;
import com.project.BloodBridge.repository.DonorOrSeekerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonorOrSeekerService {

    @Autowired
    private DonorOrSeekerRepository donorOrSeekerRepository;

    @Autowired
    private PostRepository postRepository;

    public DonorOrSeeker createUserAccount(DonorOrSeeker donorOrSeeker) {
        DonorOrSeeker u = donorOrSeekerRepository.findByPhoneNumber(donorOrSeeker.getPhoneNumber());
        if(u == null){
            try {
                return donorOrSeekerRepository.save(donorOrSeeker);
            }catch (Exception exception){
                exception.printStackTrace();
            }
        }
        return null;
    }


    public DonorOrSeeker updateAccount(DonorOrSeeker updatedDonorOrSeeker) {
        DonorOrSeeker u = donorOrSeekerRepository.findByPhoneNumber(updatedDonorOrSeeker.getPhoneNumber());
        if(u != null){
            try {
                return donorOrSeekerRepository.save(updatedDonorOrSeeker);
            }catch (Exception exception){
                exception.printStackTrace();
            }
        }
        return null;
    }


    public List<Post> createBloodPost(Post post, String postGivingUserId) {
        DonorOrSeeker donorOrSeeker = donorOrSeekerRepository.findByPhoneNumber(postGivingUserId);
        if(donorOrSeeker != null){
            try{
                donorOrSeeker.getPosts().add(post);
                post.setDonorOrSeeker(donorOrSeeker);
                donorOrSeekerRepository.save(donorOrSeeker);
                return postRepository.findAll();
            }catch (Exception exception){
                exception.printStackTrace();
            }
        }
        return null;
    }

    public List<Post> showAllPost() {
        return postRepository.findAll();
    }

    public DonorOrSeeker showUserProfile(String id) {
        return donorOrSeekerRepository.findByPhoneNumber(id);
    }

    public Post showSpecificPost(int bloodPostId) {
        return postRepository.findByPostId(bloodPostId);
    }

    public Post editPost(String userID, int postId, Post post) {
        DonorOrSeeker donorOrSeeker = donorOrSeekerRepository.findByPhoneNumber(userID);
        List<Post> currentUserPosts = donorOrSeeker.getPosts();

        for(Post p : currentUserPosts){
            if(p.getPostId() == postId){
                updateExistingPost(p, post);
                donorOrSeeker.setPosts(currentUserPosts);
                break;
            }
        }
        try {
            donorOrSeekerRepository.save(donorOrSeeker);
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return postRepository.findByPostId(post.getPostId());
    }

    private void updateExistingPost(Post p, Post post) {
        p.setContact(post.getContact());
        p.setBloodGroup(post.getBloodGroup());
        p.setBloodAmount(post.getBloodAmount());
        p.setDonationDate(post.getDonationDate());
        p.setUpazillaOrThana(post.getUpazillaOrThana());
        p.setDistrict(post.getDistrict());
        p.setDivision(post.getDivision());
    }

    public List<Post> showMyAllPosts(String userId) {
        return donorOrSeekerRepository.findByPhoneNumber(userId).getPosts();
    }
}
