// SRN: PES2UG24CS823 - Sharath Gowda GR
// File: HighPriorityMatchingStrategy.java
// Design Pattern: Strategy - High priority matching for CRITICAL patients

package com.donation.patterns.strategy;

import com.donation.model.Donor;
import com.donation.model.Request;
import org.springframework.stereotype.Component;
import java.util.List;

// Strategy Pattern: High priority algorithm
// Used when urgency level is CRITICAL or HIGH
@Component
public class HighPriorityMatchingStrategy implements MatchingStrategy {

    @Override
    public Donor findBestMatch(Request request, List<Donor> availableDonors) {
        // High priority: match by blood type first, take first available
        return availableDonors.stream()
            .filter(d -> d.getBloodType().equals(request.getBloodType()))
            .filter(Donor::isAvailable)
            .findFirst()
            .orElse(null);
    }
}
