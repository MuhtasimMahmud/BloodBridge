package com.project.BloodBridge.service;

import com.project.BloodBridge.model.Post;
import com.project.BloodBridge.model.User;
import com.project.BloodBridge.repository.PostRepository;
import com.project.BloodBridge.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    public User createUserAccount(User user) {
        User u = userRepository.findByPhoneNumber(user.getPhoneNumber());
        if(u == null){
            try {
                return userRepository.save(user);
            }catch (Exception exception){
                exception.printStackTrace();
            }
        }
        return null;
    }


    public User updateAccount(User updatedUser) {
        User u = userRepository.findByPhoneNumber(updatedUser.getPhoneNumber());
        if(u != null){
            try {
                return userRepository.save(updatedUser);
            }catch (Exception exception){
                exception.printStackTrace();
            }
        }
        return null;
    }


    public List<Post> createBloodPost(Post post, String postGivingUserId) {
        User user = userRepository.findByPhoneNumber(postGivingUserId);
        if(user != null){
            try{
                user.getPosts().add(post);
                post.setUser(user);
                userRepository.save(user);
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

    public User showUserProfile(String id) {
        return userRepository.findByPhoneNumber(id);
    }

    public Post showSpecificPost(int bloodPostId) {
        return postRepository.findByPostId(bloodPostId);
    }

    public Post editPost(String userID, int postId, Post post) {
        User user = userRepository.findByPhoneNumber(userID);
        List<Post> currentUserPosts = user.getPosts();

        for(Post p : currentUserPosts){
            if(p.getPostId() == postId){
                updateExistingPost(p, post);
                user.setPosts(currentUserPosts);
                break;
            }
        }
        try {
            userRepository.save(user);
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
        return userRepository.findByPhoneNumber(userId).getPosts();
    }
}
