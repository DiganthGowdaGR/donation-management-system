// SRN: PES2UG23CS364 - Nandani Sonale
// File: DonorRepository.java
// Role in MVC: Model - Data access for Donor

package com.donation.repository;

import com.donation.model.Donor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DonorRepository extends JpaRepository<Donor, Long> {
    List<Donor> findByBloodType(String bloodType);
    List<Donor> findByAvailableTrue();
    List<Donor> findByOrganType(String organType);
}
