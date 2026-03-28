// SRN: PES2UG24CS823 - Sharath Gowda GR
// File: User.java
// Role in MVC: Model - Base entity for all users

package com.donation.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    private String password;

    private String phone;

    @Enumerated(EnumType.STRING)
    private Role role;

    public enum Role {
        DONOR, PATIENT, ADMIN
    }
}
