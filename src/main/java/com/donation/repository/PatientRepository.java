package com.donation.repository;

import com.donation.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findByRequiredBloodType(String bloodType);
    List<Patient> findByUrgencyLevel(String urgencyLevel);
}
