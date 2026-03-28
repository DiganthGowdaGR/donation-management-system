// SRN: PES2UG24CS823 - Sharath Gowda GR
// File: RequestServiceImpl.java
// Role in MVC: Model - Service implementation
// Design Pattern: Strategy used for donor matching

package com.donation.service.impl;

import com.donation.model.Request;
import com.donation.repository.RequestRepository;
import com.donation.service.RequestService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RequestServiceImpl implements RequestService {

    // Design Principle: Dependency Inversion
    private final RequestRepository requestRepository;

    public RequestServiceImpl(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    @Override
    public Request save(Request request) {
        return requestRepository.save(request);
    }

    @Override
    public List<Request> getAllRequests() {
        return requestRepository.findAll();
    }

    @Override
    public Optional<Request> getById(Long id) {
        return requestRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        requestRepository.deleteById(id);
    }

    @Override
    public List<Request> getByStatus(String status) {
        return requestRepository.findByStatus(status);
    }

    @Override
    public List<Request> getEmergencyRequests() {
        // Returns only CRITICAL and HIGH urgency requests
        List<Request> critical = requestRepository.findByUrgencyLevel("CRITICAL");
        List<Request> high = requestRepository.findByUrgencyLevel("HIGH");
        critical.addAll(high);
        return critical;
    }

    @Override
    public Request updateStatus(Long id, String status) {
        Request request = requestRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Request not found: " + id));
        request.updateStatus(status);
        return requestRepository.save(request);
    }
}
