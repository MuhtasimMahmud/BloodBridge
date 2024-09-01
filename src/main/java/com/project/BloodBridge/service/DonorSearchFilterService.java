package com.project.BloodBridge.service;

import com.project.BloodBridge.model.Donor;
import com.project.BloodBridge.model.User;
import com.project.BloodBridge.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DonorSearchFilterService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findDonorWithFilter(Donor donor) {
        return userRepository.findDonorWithFilter(
                donor.getBloodGroup(),
                donor.getNeedDate().minusDays(90),
                donor.getUpazillaOrThana(),
                donor.getDistrict(),
                donor.getDivision()
        );
    }
}
