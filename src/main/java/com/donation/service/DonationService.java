// SRN: PES2UG23CS363 - Nandan
// File: DonationService.java
// Role in MVC: Model - Service interface for donation logic

package com.donation.service;

import com.donation.model.Donation;
import java.util.List;
import java.util.Optional;

public interface DonationService {
    Donation save(Donation donation);
    List<Donation> getAllDonations();
    Optional<Donation> getById(Long id);
    void deleteById(Long id);
    List<Donation> findByStatus(String status);
}
