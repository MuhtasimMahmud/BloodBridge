package com.project.BloodBridge.controller;

import com.project.BloodBridge.model.Blood;
import com.project.BloodBridge.model.Sandhani;
import com.project.BloodBridge.service.SandhaniService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SondhaniController {

    @Autowired
    private SandhaniService sandhaniService;

    @PostMapping("/createSandhaniAccount")
    public Sandhani registerAccount(@RequestBody Sandhani sandhani){
        return sandhaniService.registerShandhaniAccount(sandhani);
    }

    @PostMapping("/addBlood/{sandhaniId}")
    public List<Blood> addBlood(@RequestBody Blood blood, @PathVariable int sandhaniId){
        return sandhaniService.addBlood(sandhaniId, blood);
    }

    @GetMapping("/bloodBank/{sandhaniId}")
    public List<Blood> bloodBank(@PathVariable int sandhaniId){
        return sandhaniService.showBloodBank(sandhaniId);
    }

    @PutMapping("/bloodBank/{sandhaniId}/{bloodGroup}/{updatedQuantity}")
    public List<Blood> bloodList(@PathVariable int sandhaniId, @PathVariable String bloodGroup, @PathVariable int updatedQuantity){
        return sandhaniService.updateBloodBank(sandhaniId, bloodGroup, updatedQuantity);
    }


}
