package com.project.BloodBridge.repository;

import com.project.BloodBridge.model.Sandhani;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SandhaniRepository extends JpaRepository<Sandhani, Integer> {

    Sandhani findById(int id);
}
