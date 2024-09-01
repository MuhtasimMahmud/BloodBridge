package com.project.BloodBridge.repository;

import com.project.BloodBridge.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {

    Post findByPostId(int bloodPostId);

    List<Post> findAll();

    // Custom query method using JPQL with dynamic parameters
    @Query("SELECT p FROM Post p WHERE " +
            "(:bloodGroup IS NULL OR p.bloodGroup = :bloodGroup) AND " +
            "(:donationDate IS NULL OR p.donationDate = :donationDate) AND " +
            "(:upazillaOrThana IS NULL OR p.upazillaOrThana = :upazillaOrThana) AND " +
            "(:district IS NULL OR p.district = :district) AND " +
            "(:division IS NULL OR p.division = :division)")
    List<Post> findAllWithFilters(
            @Param("bloodGroup") String bloodGroup,
            @Param("donationDate") LocalDate donationDate,
            @Param("upazillaOrThana") String upazillaOrThana,
            @Param("district") String district,
            @Param("division") String division
    );
}
