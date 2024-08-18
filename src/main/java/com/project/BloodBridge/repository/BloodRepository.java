package com.project.BloodBridge.repository;

import com.project.BloodBridge.model.Blood;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BloodRepository extends JpaRepository<Blood, Integer> {

    List<Blood> findAllBySandhaniId(int id);

}
