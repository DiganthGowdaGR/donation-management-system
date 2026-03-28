// SRN: PES2UG24CS823 - Sharath Gowda GR
// File: Request.java
// Role in MVC: Model - Represents a blood/organ request by a patient

package com.donation.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "requests")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long requestId;

    private Long patientId;
    private String requestType;   // BLOOD or ORGAN
    private String bloodType;
    private String organType;
    private LocalDate requestDate;
    private String status;        // PENDING, MATCHED, FULFILLED, CANCELLED
    private String urgencyLevel;  // CRITICAL, HIGH, MEDIUM, LOW

    // Method from class diagram
    public void updateStatus(String newStatus) {
        this.status = newStatus;
    }
}
