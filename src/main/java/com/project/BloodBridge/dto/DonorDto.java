package com.project.BloodBridge.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DonorDto {
    private String bloodGroup;
    private LocalDate needDate;
    private String upazillaOrThana;
    private String district;
    private String division;


}
