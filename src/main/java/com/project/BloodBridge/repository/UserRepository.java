package com.project.BloodBridge.repository;

import com.project.BloodBridge.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {


}
