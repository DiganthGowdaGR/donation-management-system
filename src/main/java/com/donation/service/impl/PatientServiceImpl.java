// SRN: PES2UG23CS364 - Nandani Sonale
// File: PatientServiceImpl.java
// Role in MVC: Model - Service implementation

package com.donation.service.impl;

import com.donation.model.Patient;
import com.donation.repository.PatientRepository;
import com.donation.service.PatientService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Optional<Patient> getById(Long id) {
        return patientRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        patientRepository.deleteById(id);
    }

    @Override
    public List<Patient> getByUrgencyLevel(String urgencyLevel) {
        return patientRepository.findByUrgencyLevel(urgencyLevel);
    }
}
