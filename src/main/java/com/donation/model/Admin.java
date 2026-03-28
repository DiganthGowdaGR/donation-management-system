// SRN: PES2UG23CS363 - Nandan
// File: Admin.java
// Role in MVC: Model - Represents an admin user

package com.donation.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "admins")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adminId;

    private String name;
    private String email;
    private String adminCode;
}
