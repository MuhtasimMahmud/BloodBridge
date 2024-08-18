package com.project.BloodBridge.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Blood {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int bloodId;
    String bloodGroup;
    int quantity;

    @ManyToOne
    @JsonBackReference
    private Sandhani sandhani;
}
