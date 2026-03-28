// SRN: PES2UG23CS364 - Nandani Sonale
// File: PatientService.java
// Role in MVC: Model - Service interface
// Design Principle: Interface Segregation - separate from DonorService

package com.donation.service;

import com.donation.model.Patient;
import java.util.List;
import java.util.Optional;

public interface PatientService {
    Patient save(Patient patient);
    List<Patient> getAllPatients();
    Optional<Patient> getById(Long id);
    void deleteById(Long id);
    List<Patient> getByUrgencyLevel(String urgencyLevel);
}
