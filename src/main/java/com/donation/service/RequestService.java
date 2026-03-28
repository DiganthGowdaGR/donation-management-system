// SRN: PES2UG24CS823 - Sharath Gowda GR
// File: RequestService.java
// Role in MVC: Model - Service interface
// Design Principle: Dependency Inversion - depend on abstraction

package com.donation.service;

import com.donation.model.Request;
import java.util.List;
import java.util.Optional;

public interface RequestService {
    Request save(Request request);
    List<Request> getAllRequests();
    Optional<Request> getById(Long id);
    void deleteById(Long id);
    List<Request> getByStatus(String status);
    List<Request> getEmergencyRequests();
    Request updateStatus(Long id, String status);
}
