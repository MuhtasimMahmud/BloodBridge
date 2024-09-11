package com.project.BloodBridge.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int postId;
    private String bloodGroup;
    private int bloodAmount;
    private LocalDate donationDate;
    private String contact;
    private String upazillaOrThana;
    private String district;
    private String division;

    @ManyToOne
    @JsonBackReference
    private DonorOrSeeker donorOrSeeker;

}
