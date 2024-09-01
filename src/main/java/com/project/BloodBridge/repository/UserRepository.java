package com.project.BloodBridge.repository;

import com.project.BloodBridge.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {

    User findByPhoneNumber(String phoneNumber);

    @Query("SELECT u FROM User u WHERE " +
            "(:bloodGroup IS NULL OR u.bloodGroup = :bloodGroup) AND " +
            "(:lastDonationDate IS NULL OR u.lastDonationDate < :lastDonationDate) AND " +
            "(:upazillaOrThana IS NULL OR u.upazillaOrThana = :upazillaOrThana) AND " +
            "(:district IS NULL OR u.district = :district) AND " +
            "(:division IS NULL OR u.division = :division)")
    List<User> findDonorWithFilter(
            @Param("bloodGroup") String bloodGroup,
            @Param("lastDonationDate") LocalDate lastDonationDate,
            @Param("upazillaOrThana") String upazillaOrThana,
            @Param("district") String district,
            @Param("division") String division
    );

}
