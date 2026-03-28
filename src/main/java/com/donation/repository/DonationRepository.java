// SRN: PES2UG23CS363 - Nandan
// File: DonationRepository.java
// Role in MVC: Model - Data access for Donation

package com.donation.repository;

import com.donation.model.Donation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {
    List<Donation> findByDonorName(String donorName);
    List<Donation> findByPatientName(String patientName);
    List<Donation> findByStatus(String status);
}
