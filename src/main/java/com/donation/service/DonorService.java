// SRN: PES2UG23CS364 - Nandani Sonale
// File: DonorService.java
// Role in MVC: Model - Service interface
// Design Principle: Dependency Inversion

package com.donation.service;

import com.donation.model.Donor;
import java.util.List;
import java.util.Optional;

public interface DonorService {
    Donor save(Donor donor);
    List<Donor> getAllDonors();
    Optional<Donor> getById(Long id);
    void deleteById(Long id);
    List<Donor> getAvailableDonors();
    List<Donor> findByBloodType(String bloodType);
}
