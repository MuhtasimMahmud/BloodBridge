package com.project.BloodBridge.service;

import com.project.BloodBridge.model.Post;
import com.project.BloodBridge.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostSearchFilterService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> searchFilter(Post post) {
        return postRepository.findAllWithFilters(
                post.getBloodGroup(),
                post.getDonationDate(),
                post.getUpazillaOrThana(),
                post.getDistrict(),
                post.getDivision()
        );
    }
}
