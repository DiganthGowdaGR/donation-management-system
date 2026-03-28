// SRN: PES2UG23CS364 - Nandani Sonale
// File: Patient.java (copied here for compilation)

package com.donation.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "patients")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phone;
    private String requiredBloodType;
    private String requiredOrgan;
    private String urgencyLevel;
}
