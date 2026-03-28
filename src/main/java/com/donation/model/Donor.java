// SRN: PES2UG23CS364 - Nandani Sonale
// File: Donor.java
// Role in MVC: Model - Represents a blood/organ donor

package com.donation.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "donors")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Donor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phone;
    private String bloodType;  // A+, A-, B+, B-, AB+, AB-, O+, O-
    private String organType;  // KIDNEY, LIVER, HEART, LUNG, CORNEA, NONE
    private boolean available;

    // Method from class diagram
    public void donateBlood() {
        this.available = false;
    }

    // Method from class diagram
    public void donateOrgan() {
        this.available = false;
    }

    // Method from class diagram
    public String viewDonationStatus() {
        return available ? "Available" : "Not Available";
    }
}
