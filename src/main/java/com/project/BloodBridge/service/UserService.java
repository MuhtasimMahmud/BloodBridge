package com.project.BloodBridge.service;

import com.project.BloodBridge.model.Post;
import com.project.BloodBridge.model.User;
import com.project.BloodBridge.repository.PostRepository;
import com.project.BloodBridge.repository.UserRepository;
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


    public List<Post> createBloodPost(Post post, String id) {
        User user = userRepository.findByPhoneNumber(id);
        if(user != null){
            try{
                user.getPosts().add(post);
                postRepository.save(post);
                userRepository.save(user);
                return postRepository.findAll();
            }catch (Exception exception){
                exception.printStackTrace();
            }
        }
        return null;
    }
}
