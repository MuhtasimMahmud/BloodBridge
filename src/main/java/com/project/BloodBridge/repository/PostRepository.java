package com.project.BloodBridge.repository;

import com.project.BloodBridge.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {

    Post findByPostId(int bloodPostId);

    List<Post> findAll();
}
