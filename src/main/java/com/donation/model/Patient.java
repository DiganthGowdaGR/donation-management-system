// SRN: PES2UG23CS364 - Nandani Sonale
// File: Patient.java
// Role in MVC: Model - Represents a patient needing blood/organ

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
    private String urgencyLevel; // CRITICAL, HIGH, MEDIUM, LOW

    // Method from class diagram
    public void requestBlood() {
        System.out.println("Blood request raised for: " + requiredBloodType);
    }

    // Method from class diagram
    public void requestOrgan() {
        System.out.println("Organ request raised for: " + requiredOrgan);
    }

    // Method from class diagram
    public boolean trackRequestStatus() {
        return urgencyLevel != null;
    }
}
