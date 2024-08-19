package com.project.BloodBridge.repository;

import com.project.BloodBridge.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
