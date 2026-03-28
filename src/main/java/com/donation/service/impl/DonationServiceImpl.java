// SRN: PES2UG23CS363 - Nandan D
// File: DonationServiceImpl.java
// Role in MVC: Model - Service implementation

package com.donation.service.impl;

import com.donation.model.Donation;
import com.donation.repository.DonationRepository;
import com.donation.service.DonationService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DonationServiceImpl implements DonationService {

    private final DonationRepository donationRepository;

    public DonationServiceImpl(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    @Override
    public Donation save(Donation donation) {
        return donationRepository.save(donation);
    }

    @Override
    public List<Donation> getAllDonations() {
        return donationRepository.findAll();
    }

    @Override
    public Optional<Donation> getById(Long id) {
        return donationRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        donationRepository.deleteById(id);
    }

    @Override
    public List<Donation> findByStatus(String status) {
        return donationRepository.findByStatus(status);
    }
}
