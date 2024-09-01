package com.project.BloodBridge.controller;

import com.project.BloodBridge.model.Donor;
import com.project.BloodBridge.model.User;
import com.project.BloodBridge.service.DonorSearchFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DonorSearchFilterController {

    @Autowired
    private DonorSearchFilterService donorSearchFilterService;

    @GetMapping("/findDonorWithFilter")
    public List<User> findDonor(@RequestBody Donor donor){
        return donorSearchFilterService.findDonorWithFilter(donor);
    }

}
