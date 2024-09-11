package com.project.BloodBridge.service;

import com.project.BloodBridge.dto.DonorDto;
import com.project.BloodBridge.model.DonorOrSeeker;
import com.project.BloodBridge.repository.DonorOrSeekerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonorSearchFilterService {

    @Autowired
    private DonorOrSeekerRepository donorOrSeekerRepository;

    public List<DonorOrSeeker> findDonorWithFilter(DonorDto donorDto) {
        return donorOrSeekerRepository.findDonorWithFilter(
                donorDto.getBloodGroup(),
                donorDto.getNeedDate().minusDays(90),
                donorDto.getUpazillaOrThana(),
                donorDto.getDistrict(),
                donorDto.getDivision()
        );
    }
}
