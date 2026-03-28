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
