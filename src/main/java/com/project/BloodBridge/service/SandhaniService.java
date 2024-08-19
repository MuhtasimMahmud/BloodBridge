package com.project.BloodBridge.service;

import com.project.BloodBridge.model.Blood;
import com.project.BloodBridge.model.Sandhani;
import com.project.BloodBridge.repository.BloodRepository;
import com.project.BloodBridge.repository.SandhaniRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SandhaniService {

    @Autowired
    private SandhaniRepository sandhaniRepository;

    @Autowired
    private BloodRepository bloodRepository;

    public Sandhani registerShandhaniAccount(Sandhani sandhani){
        Sandhani s = sandhaniRepository.findById(sandhani.getId());
        if(s == null){
            try {
                System.out.println("Try block");
                return sandhaniRepository.save(sandhani);
            }catch (Exception exception){
                exception.printStackTrace();
            }
        }
        return null;
    }

    public List<Blood> addBlood(int sandhaniId, Blood blood) {
        Sandhani sandhani = sandhaniRepository.findById(sandhaniId);
        if(sandhani != null){
            blood.setSandhani(sandhani);
            sandhani.getBloodBank().add(blood);
        }else {
            return null;
        }

        try{
            sandhaniRepository.save(sandhani);
        }catch (Exception e){
            e.printStackTrace();
        }
        return bloodRepository.findAllBySandhaniId(sandhaniId);
    }

    public List<Blood> showBloodBank(int sandhaniId) {
        return bloodRepository.findAllBySandhaniId(sandhaniId);
    }

    public List<Blood> updateBloodBank(int sandhaniId, String bloodGroup, int updatedQuantity) {
        Sandhani sandhani = sandhaniRepository.findById(sandhaniId);
        if(sandhani != null){
            List<Blood> blood = sandhani.getBloodBank();
            for(Blood b : blood){
                if(b.getBloodGroup().equals(bloodGroup)){
                    b.setQuantity(updatedQuantity);
                    sandhani.setBloodBank(blood);
                    break;
                }
            }
            try {
                sandhaniRepository.save(sandhani);
            }catch (Exception exception){
                exception.printStackTrace();
            }
        }
        return bloodRepository.findAllBySandhaniId(sandhaniId);
    }

    public Sandhani updateProfile(Sandhani sandhani) {
        Sandhani sandhani1 = sandhaniRepository.findById(sandhani.getId());
        if (sandhani1 != null){
            try {
                sandhaniRepository.save(sandhani);
            }catch (Exception exception){
                exception.printStackTrace();
            }
        }
        return sandhani;
    }
}
