// SRN: PES2UG24CS823 - Sharath Gowda GR
// File: NormalMatchingStrategy.java
// Design Pattern: Strategy - Normal matching for LOW/MEDIUM patients

package com.donation.patterns.strategy;

import com.donation.model.Donor;
import com.donation.model.Request;
import org.springframework.stereotype.Component;
import java.util.List;

// Strategy Pattern: Normal matching algorithm
// Used when urgency level is MEDIUM or LOW
@Component
public class NormalMatchingStrategy implements MatchingStrategy {

    @Override
    public Donor findBestMatch(Request request, List<Donor> availableDonors) {
        // Normal: just find first available donor with matching blood type
        return availableDonors.stream()
            .filter(Donor::isAvailable)
            .filter(d -> d.getBloodType().equals(request.getBloodType()))
            .findFirst()
            .orElse(null);
    }
}
