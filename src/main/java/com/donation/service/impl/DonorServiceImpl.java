// SRN: PES2UG23CS364 - Nandani Sonale
// File: DonorServiceImpl.java (copied here for compilation)

package com.donation.service.impl;

import com.donation.model.Donor;
import com.donation.repository.DonorRepository;
import com.donation.service.DonorService;
import com.donation.patterns.observer.DonationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DonorServiceImpl implements DonorService {

    private final DonorRepository donorRepository;
    private final ApplicationEventPublisher eventPublisher;

    public DonorServiceImpl(DonorRepository donorRepository,
                             ApplicationEventPublisher eventPublisher) {
        this.donorRepository = donorRepository;
        this.eventPublisher = eventPublisher;
    }

    @Override
    public Donor save(Donor donor) {
        Donor saved = donorRepository.save(donor);
        eventPublisher.publishEvent(
            new DonationEvent(this, saved.getId(),
                "NEW_DONOR", "New donor: " + saved.getName())
        );
        return saved;
    }

    @Override
    public List<Donor> getAllDonors() {
        return donorRepository.findAll();
    }

    @Override
    public Optional<Donor> getById(Long id) {
        return donorRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        donorRepository.deleteById(id);
    }

    @Override
    public List<Donor> getAvailableDonors() {
        return donorRepository.findByAvailableTrue();
    }

    @Override
    public List<Donor> findByBloodType(String bloodType) {
        return donorRepository.findByBloodType(bloodType);
    }
}
