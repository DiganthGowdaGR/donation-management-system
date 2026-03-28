// SRN: PES2UG23CS364 - Nandani Sonale
// File: Donor.java (copied here for compilation)

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
    private String bloodType;
    private String organType;
    private boolean available;

    public void donateBlood() { this.available = false; }
    public void donateOrgan() { this.available = false; }
    public String viewDonationStatus() {
        return available ? "Available" : "Not Available";
    }
}
