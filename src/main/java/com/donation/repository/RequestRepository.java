// SRN: PES2UG24CS823 - Sharath Gowda GR
// File: RequestRepository.java
// Role in MVC: Model - Data access for Request

package com.donation.repository;

import com.donation.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {
    List<Request> findByStatus(String status);
    List<Request> findByPatientId(Long patientId);
    List<Request> findByUrgencyLevel(String urgencyLevel);
    List<Request> findByRequestType(String requestType);
    List<Request> findByBloodType(String bloodType);
}
