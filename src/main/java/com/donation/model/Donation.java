// SRN: PES2UG23CS363 - Nandan
// File: Donation.java
// Role in MVC: Model - Represents a donation record

package com.donation.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "donations")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String donorName;
    private String patientName;
    private String bloodType;
    private String organType;
    private int quantity;
    private LocalDateTime donationDate;
    private String status; // e.g. COMPLETED, PENDING
}
