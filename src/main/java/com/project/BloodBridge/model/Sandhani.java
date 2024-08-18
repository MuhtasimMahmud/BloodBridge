package com.project.BloodBridge.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "sandhani")
public class Sandhani {

    @Id
    private int id;
    private String name;
    private String address;
    private String contact1;
    private String contact2;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sandhani")
    @JsonManagedReference
    private List<Blood> bloodBank = new ArrayList<>();
}
